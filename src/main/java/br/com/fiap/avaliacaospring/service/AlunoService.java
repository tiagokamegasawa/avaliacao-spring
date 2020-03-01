package br.com.fiap.avaliacaospring.service;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;

public interface AlunoService {

    AlunoDTO create(CreateAlunoDTO createAlunoDTO);

}
