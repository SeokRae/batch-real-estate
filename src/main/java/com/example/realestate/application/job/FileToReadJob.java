package com.example.realestate.application.job;

import com.example.realestate.application.domain.entity.RealEstateEntity;
import com.example.realestate.application.domain.files.RealEstateFileVO;
import com.example.realestate.application.domain.files.RealEstateType;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.persistence.EntityManagerFactory;

import static org.springframework.batch.item.file.transform.DelimitedLineTokenizer.DELIMITER_COMMA;

@Configuration
@RequiredArgsConstructor
public class FileToReadJob {
	
	private static final int CHUNK_SIZE = 2000;
	@Value("${file.real-estate}")
	private String filePath;
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	
	@Bean
	public Job fileItemReaderJob() {
		return jobBuilderFactory.get("txtFileItemReaderJob")
			.incrementer(new RunIdIncrementer())
			.start(fileItemReaderStep())
			.build();
	}
	
	@Bean
	public Step fileItemReaderStep() {
		return stepBuilderFactory.get("txtFileItemReaderStep")
			.<RealEstateFileVO, RealEstateEntity>chunk(CHUNK_SIZE)
			.reader(txtFileItemReader(filePath))
			.processor((ItemProcessor<RealEstateFileVO, RealEstateEntity>) RealEstateFileVO::toEntity
			)
			.writer(jpaItemWriter())
			.build();
	}
	
	private ItemWriter<? super RealEstateEntity> jpaItemWriter() {
		JpaItemWriter<RealEstateEntity> jpaItemWriter = new JpaItemWriter<>();
		jpaItemWriter.setEntityManagerFactory(entityManagerFactory);
		return jpaItemWriter;
	}
	
	public FlatFileItemReader<RealEstateFileVO> txtFileItemReader(String filePath) {
		return new FlatFileItemReader<>() {{
			/* 파일 경로 읽기 Resource 설정 */
			setResource(new ClassPathResource(filePath));
			/* 파일 인코딩 문제로 EUC-KR로 설정 */
			setEncoding("EUC-KR");
			/* excel 헤더 첫 번째 row Skip*/
			setLinesToSkip(1);
			/* [FlatFileReader 필수 설정] LineMapper 설정하기 */
			setLineMapper(new DefaultLineMapper<>() {{
				/* [LineMapper 필수 설정] LineTokenizer로 데이터 Mapping */
				setLineTokenizer(
					/* [DelimitedLineTokenizer 클래스의 필수 값] delimiter 설정 */
					new DelimitedLineTokenizer(DELIMITER_COMMA) {{
						/*  LibraryEntitys의 key 값 매핑을 위한 Name 설정 */
						setNames(RealEstateType.fieldNames());
						/* 원본 CSV 파일에서 모든 필드가 필요없어서 필요한 컬럼 값만 조회 */
						// setIncludedFields(0, 1, 2, 3);
					}});
				/* BeanWrapperFieldSetMapper 는 Map 을 FieldSet의 객체로 변환하는 것으로 target 객체의 setter / getter가 필요함  */
				setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
					/* CSV 파일의 값 부분을 Vo로 매핑 하기 위한 설정 */
					setTargetType(RealEstateFileVO.class);
				}});
			}});
		}};
	}
}