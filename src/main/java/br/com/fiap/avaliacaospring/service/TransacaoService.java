package br.com.fiap.avaliacaospring.service;

import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.TransacaoDTO;

public interface TransacaoService {

    TransacaoDTO create(CreateTransacaoDTO createTransacaoDTO);

}
