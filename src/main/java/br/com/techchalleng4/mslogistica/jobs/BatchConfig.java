package br.com.techchalleng4.mslogistica.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class BatchConfig {

    @Bean
    public Job process(JobRepository jobRepository, Step step){
        return new JobBuilder("simpleJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("step", jobRepository)
                .<String, String> chunk(20,transactionManager )
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemReader<String> reader() {
        // Leitura de dados estáticos (lista de exemplo)
        return new ListItemReader<>(List.of("primeiro", "segundo", "terceiro"));
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        // Transformar cada item em letras maiúsculas
        return new ShippingCarrierProcessor();
    }

    @Bean
    public ItemWriter<String> writer() {
        // Escrever cada item no console
        return items -> items.forEach(System.out::println);
    }
}
