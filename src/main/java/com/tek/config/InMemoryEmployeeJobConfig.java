package com.tek.config;

import com.tek.dto.employee.Employee;
import com.tek.steps.InMemoryEmployeeReader;
import com.tek.steps.LoggingEmployeeProcessor;
import com.tek.steps.LoggingEmployeeWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rashid Jilani
 */
@Configuration
public class InMemoryEmployeeJobConfig {

    @Bean
    ItemReader<Employee> inMemoryEmployeeReader() {
        return new InMemoryEmployeeReader();
    }

    @Bean
    ItemProcessor<Employee, Employee> inMemoryEmployeeProcessor() {
        return new LoggingEmployeeProcessor();
    }

    @Bean
    ItemWriter<Employee> inMemoryEmployeeWriter() {
        return new LoggingEmployeeWriter();
    }

    @Bean
    Step inMemoryEmployeeStep(ItemReader<Employee> inMemoryEmployeeReader,
                             ItemProcessor<Employee, Employee> inMemoryEmployeeProcessor,
                             ItemWriter<Employee> inMemoryEmployeeWriter,
                             StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("inMemoryEmployeeStep")
                .<Employee, Employee>chunk(3)
                .reader(inMemoryEmployeeReader)
                .processor(inMemoryEmployeeProcessor)
                .writer(inMemoryEmployeeWriter)
                .build();
    }

    @Bean
    Job inMemoryEmployeeJob(JobBuilderFactory jobBuilderFactory,
                           @Qualifier("inMemoryEmployeeStep") Step inMemoryEmployeeStep) {
        return jobBuilderFactory.get("inMemoryEmployeeJob")
                .incrementer(new RunIdIncrementer())
                .flow(inMemoryEmployeeStep)
                .end()
                .build();
    }
}
