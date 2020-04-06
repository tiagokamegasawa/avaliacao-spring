package br.com.fiap.avaliacaospring.batch.writer;

import br.com.fiap.avaliacaospring.dto.CreateBatchTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.CreateCartaoCreditoDTO;
import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.service.AlunoService;
import br.com.fiap.avaliacaospring.service.TransacaoService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("transacaoItemWriter")
public class TransacaoItemWriter implements ItemWriter<CreateBatchTransacaoDTO> {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private AlunoService alunoService;

    @Override
    public void write(List<? extends CreateBatchTransacaoDTO> items) {
        items.forEach(createBatch -> {
            alunoService.update(createBatch.getIdAluno(), new CreateCartaoCreditoDTO(createBatch.getUltimosDigitos()));
            createBatch.getTransacoes().forEach(transacao -> transacaoService.create(transacao));
        });
    }

}
