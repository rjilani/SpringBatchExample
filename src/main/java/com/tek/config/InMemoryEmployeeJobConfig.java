package com.tek.config;

import com.tek.dto.employee.Employee;
import com.tek.steps.InMemoryEmployeeReader;
import com.tek.steps.EmployeeProcessor;
import com.tek.steps.EmployeeWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

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
        return new EmployeeProcessor();
    }

    @Bean
    ItemWriter<Employee> inMemoryEmployeeWriter() {
        return new EmployeeWriter();
    }
    
    @Bean
    public Step inMemoryEmployeeStep(final JobRepository jobRepository, final PlatformTransactionManager transactionManager, 
    		ItemReader<Employee> inMemoryEmployeeReader, ItemProcessor<Employee, Employee> inMemoryEmployeeProcessor,
            ItemWriter<Employee> inMemoryEmployeeWriter)  {
        return new StepBuilder("inMemoryEmployeeStep", jobRepository)
                .<Employee, Employee>chunk(3, transactionManager)
                .reader(inMemoryEmployeeReader)
                .processor(inMemoryEmployeeProcessor)
                .writer(inMemoryEmployeeWriter)
                .build();
    }
    
    @Bean
    public Job inMemoryEmployeeJob(final JobRepository jobRepository, final PlatformTransactionManager transactionManager, 
    		ItemReader<Employee> inMemoryEmployeeReader, ItemProcessor<Employee, Employee> inMemoryEmployeeProcessor,
            ItemWriter<Employee> inMemoryEmployeeWriter) {
        return new JobBuilder("inMemoryEmployeeJob", jobRepository)
                .start(inMemoryEmployeeStep(jobRepository, transactionManager, inMemoryEmployeeReader, inMemoryEmployeeProcessor,inMemoryEmployeeWriter))
                .build();
    }
    
    
}
