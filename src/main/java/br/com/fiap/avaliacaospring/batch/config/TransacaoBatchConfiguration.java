package br.com.fiap.avaliacaospring.batch.config;

import br.com.fiap.avaliacaospring.dto.CreateBatchTransacaoDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class TransacaoBatchConfiguration {

    @Bean("transacaoFileItemReader")
    public ItemReader<CreateBatchTransacaoDTO> itemReader(@Value("${file.transacao.path}")
                                                   Resource resource) throws Exception {
        JacksonJsonObjectReader<CreateBatchTransacaoDTO> reader = new JacksonJsonObjectReader<>(CreateBatchTransacaoDTO.class);
        reader.open(resource);
        JsonItemReader jsonItemReader = new JsonItemReader(resource, reader);
        jsonItemReader.setName("transacao_file_reader");
        return jsonItemReader;
    }

    @Bean("transacaoStep")
    public Step step(StepBuilderFactory stepBuilderFactory,
                     @Qualifier("transacaoFileItemReader") ItemReader<CreateBatchTransacaoDTO> itemReader,
                     @Qualifier("transacaoItemWriter")
                             ItemWriter<CreateBatchTransacaoDTO> itemWriter) {
        return stepBuilderFactory.get("transacao_step")
                .<CreateBatchTransacaoDTO, CreateBatchTransacaoDTO>chunk(2)
                .reader(itemReader)
                .processor(new PassThroughItemProcessor<>())
                .writer(itemWriter)
                .build();
    }

    @Bean("transacaoJob")
    public Job job(JobBuilderFactory jobBuilderFactory,
                   @Qualifier("transacaoStep") Step step) {
        return jobBuilderFactory.get("transacao_process")
                .start(step)
                .build();
    }


}
