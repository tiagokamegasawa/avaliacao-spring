package br.com.fiap.avaliacaospring.service;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;

import java.util.List;

public interface AlunoService {

    AlunoDTO create(CreateAlunoDTO createAlunoDTO);

    AlunoDTO update(Integer id, CreateAlunoDTO createAlunoDTO);

    void delete(Integer id);

    List<AlunoDTO> list();

}
