package com.example.realestate.application.job.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TmpToAreaJob {
	private final String STEP_NAME = "TMP_TO_AREA_STEP";
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	private static final int CHUNK_SIZE = 2000;
	
	@Bean(name = STEP_NAME)
	public Step jpaTmpToAreaStep() {
		return stepBuilderFactory.get(STEP_NAME)
			.chunk(CHUNK_SIZE)
			.reader(jpaTmpReader())
			.processor(jpaTmpToAreaProcessor())
			.writer(jpaAreaWriter())
			.build();
	}
	
	private ItemReader<?> jpaTmpReader() {
		return new JpaPagingItemReaderBuilder<>()
			.pageSize(CHUNK_SIZE)
			.entityManagerFactory(entityManagerFactory)
			.queryString("SELECT t FROM TB_REAL_ESTATE t")
			.build();
	}
	
	private ItemProcessor<? super Object, ?> jpaTmpToAreaProcessor() {
		return item -> {
			return null;
		};
	}
	
	private ItemWriter<? super Object> jpaAreaWriter() {
		return null;
	}
}
