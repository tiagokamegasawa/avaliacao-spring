package br.com.fiap.avaliacaospring.service.impl;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;
import br.com.fiap.avaliacaospring.entity.Aluno;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import br.com.fiap.avaliacaospring.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

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

    @Override
    public AlunoDTO update(Integer id, CreateAlunoDTO createAlunoDTO) {
        Aluno entity = alunoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setNome(ofNullable(createAlunoDTO.getNome()).orElse(entity.getNome()));
        entity.setRm(ofNullable(createAlunoDTO.getRm()).orElse(entity.getRm()));
        entity.setTurma(ofNullable(createAlunoDTO.getTurma()).orElse(entity.getTurma()));
        return new AlunoDTO(alunoRepository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        alunoRepository.deleteById(id);
    }

    @Override
    public List<AlunoDTO> list() {
        return alunoRepository.findAllDTO();
    }

}
