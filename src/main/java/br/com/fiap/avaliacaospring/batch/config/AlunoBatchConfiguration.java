package br.com.fiap.avaliacaospring.batch.config;

import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.PassThroughFieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.RegexLineTokenizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AlunoBatchConfiguration {

    @Bean("alunoFileItemReader")
    public ItemReader<FieldSet> itemReader(@Value("${file.path}") Resource resource) {

        DefaultLineMapper<FieldSet> lineMapper = new DefaultLineMapper<>();
        RegexLineTokenizer tokenizer = new RegexLineTokenizer();
        tokenizer.setRegex("(.*)([0-9]{7}) ([0-9]{3}-[0-9]{2})");
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new PassThroughFieldSetMapper());

        return new FlatFileItemReaderBuilder<FieldSet>()
                .name("file_item_reader")
                .targetType(FieldSet.class)
                .lineMapper(lineMapper)
                .resource(resource)
                .build();
    }

    @Bean("alunoItemProcessor")
    public ItemProcessor<FieldSet, CreateAlunoDTO> itemProcessor() {
        return lineToProcess -> {
            String[] values = lineToProcess.getValues();
            if (values.length == 3) {
                return new CreateAlunoDTO(values[0].trim(), values[1], values[2]);
            }
            return null;
        };
    }

    @Bean("alunoStep")
    public Step step(StepBuilderFactory stepBuilderFactory,
                     @Qualifier("alunoFileItemReader") ItemReader<FieldSet> itemReader,
                     @Qualifier("alunoItemProcessor") ItemProcessor<FieldSet, CreateAlunoDTO> itemProcessor,
                     @Qualifier("alunoItemWriter") ItemWriter<CreateAlunoDTO> itemWriter) {
        return stepBuilderFactory.get("aluno_step")
                .<FieldSet, CreateAlunoDTO>chunk(2)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean("alunoJob")
    public Job job(JobBuilderFactory jobBuilderFactory,
                   Step step) {
        return jobBuilderFactory.get("aluno_process")
                .start(step)
                .build();
    }

}
