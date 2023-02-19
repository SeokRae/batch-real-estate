package com.example.realestate.application.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TmpToMultiJob {
	private static final String JOB_NAME = "TMP_TO_ENTITIES_JOB";
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	@Bean
	public Job tmpToEntityJob() {
		return jobBuilderFactory.get(JOB_NAME)
			.start(taskStep())
			.incrementer(new RunIdIncrementer())
			.next(taskStep())
			.build();
	}
	
	private Step taskStep() {
		return stepBuilderFactory.get(JOB_NAME + "_STEP")
			.tasklet(oneToManyTasklet)
			.build();
	}
}
