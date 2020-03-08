package br.com.fiap.avaliacaospring.service;

import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.TransacaoDTO;

import java.util.List;

public interface TransacaoService {

    TransacaoDTO create(CreateTransacaoDTO createTransacaoDTO);

    TransacaoDTO update(Integer id, CreateTransacaoDTO createTransacaoDTO);

    void delete(Integer id);

    List<TransacaoDTO> list(Integer alunoId);
}
