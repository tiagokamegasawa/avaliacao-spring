package br.com.fiap.avaliacaospring.service.impl;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;
import br.com.fiap.avaliacaospring.entity.Aluno;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import br.com.fiap.avaliacaospring.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AlunoDTO create(CreateAlunoDTO createAlunoDTO) {
        Aluno entity = new Aluno();
        entity.setNome(createAlunoDTO.getNome());
        entity.setRm(createAlunoDTO.getRm());
        entity.setTurma(createAlunoDTO.getTurma());

        return new AlunoDTO(alunoRepository.save(entity));
    }

}
