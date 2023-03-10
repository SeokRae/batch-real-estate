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
			/* ?????? ?????? ?????? Resource ?????? */
			setResource(new ClassPathResource(filePath));
			/* ?????? ????????? ????????? EUC-KR??? ?????? */
			setEncoding("EUC-KR");
			/* excel ?????? ??? ?????? row Skip*/
			setLinesToSkip(1);
			/* [FlatFileReader ?????? ??????] LineMapper ???????????? */
			setLineMapper(new DefaultLineMapper<>() {{
				/* [LineMapper ?????? ??????] LineTokenizer??? ????????? Mapping */
				setLineTokenizer(
					/* [DelimitedLineTokenizer ???????????? ?????? ???] delimiter ?????? */
					new DelimitedLineTokenizer(DELIMITER_COMMA) {{
						/*  LibraryEntitys??? key ??? ????????? ?????? Name ?????? */
						setNames(RealEstateType.fieldNames());
						/* ?????? CSV ???????????? ?????? ????????? ??????????????? ????????? ?????? ?????? ?????? */
						// setIncludedFields(0, 1, 2, 3);
					}});
				/* BeanWrapperFieldSetMapper ??? Map ??? FieldSet??? ????????? ???????????? ????????? target ????????? setter / getter??? ?????????  */
				setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
					/* CSV ????????? ??? ????????? Vo??? ?????? ?????? ?????? ?????? */
					setTargetType(RealEstateFileVO.class);
				}});
			}});
		}};
	}
}