package br.com.fiap.avaliacaospring.service.impl;

import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.TransacaoDTO;
import br.com.fiap.avaliacaospring.entity.Transacao;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import br.com.fiap.avaliacaospring.repository.TransacaoRepository;
import br.com.fiap.avaliacaospring.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public TransacaoDTO create(CreateTransacaoDTO createTransacaoDTO) {
        Transacao entity = new Transacao();
        entity.setAluno(alunoRepository.getOne(createTransacaoDTO.getIdAluno()));
        entity.setDataHora(createTransacaoDTO.getDataHora());
        entity.setDescricao(createTransacaoDTO.getDescricao());
        entity.setValor(createTransacaoDTO.getValor());

        return new TransacaoDTO(repository.save(entity));
    }
}
