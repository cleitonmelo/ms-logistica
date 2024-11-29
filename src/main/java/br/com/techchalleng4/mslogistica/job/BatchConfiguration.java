package br.com.techchalleng4.mslogistica.job;

import br.com.techchalleng4.mslogistica.job.processor.LoadCarriersProcessor;
import br.com.techchalleng4.mslogistica.model.Carrier;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    @Bean
    public Job ProcessarProduto(JobRepository jobRepository, Step step){
        return new JobBuilder("processarProduto", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public Step steap(JobRepository jobRepository,
                      PlatformTransactionManager platformTransactionManager,
                      ItemReader<Carrier> itemReader,
                      ItemWriter<Carrier> itemWriter,
                      ItemProcessor<Carrier, Carrier> itemProcessor){
        return new StepBuilder("step", jobRepository)
                .<Carrier, Carrier>chunk(32, platformTransactionManager)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public ItemReader<Carrier> itemReader(){
        BeanWrapperFieldSetMapper<Carrier> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Carrier.class);
        return new FlatFileItemReaderBuilder<Carrier>()
                .name("carriersItemReader")
                .resource(new ClassPathResource("carriers.csv"))
                .delimited()
                .names("name","zipCodeStart","zipCodeEnd","deliveryLimitDays")
                .fieldSetMapper(fieldSetMapper)
                .build();
    }

    @Bean
    public ItemProcessor<Carrier,Carrier> itemProcessor(){
        return new LoadCarriersProcessor();
    }

    @Bean
    public ItemWriter<Carrier> itemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Carrier>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .dataSource(dataSource)
                .sql("INSERT INTO CARRIERS" +
                        "(NAME, ZIP_CODE_START, ZIP_CODE_END, DELIVERY_LIMIT_DAYS) " +
                        "VALUES (:name, :zipCodeStart, :zipCodeEnd, :deliveryLimitDays)")
                .build();
    }
}

