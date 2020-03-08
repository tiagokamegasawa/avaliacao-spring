package br.com.fiap.avaliacaospring.batch.writer;

import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;
import br.com.fiap.avaliacaospring.service.AlunoService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("alunoItemWriter")
public class AlunoItemWriter implements ItemWriter<CreateAlunoDTO> {

    @Autowired
    private AlunoService alunoService;

    @Override
    public void write(List<? extends CreateAlunoDTO> items) {
        items.forEach(aluno -> {
            alunoService.create(aluno);
        });
    }

}
