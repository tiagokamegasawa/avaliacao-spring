package br.com.fiap.avaliacaospring.service.impl;

import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.TransacaoDTO;
import br.com.fiap.avaliacaospring.entity.Transacao;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import br.com.fiap.avaliacaospring.repository.CartaoCreditoRepository;
import br.com.fiap.avaliacaospring.repository.TransacaoRepository;
import br.com.fiap.avaliacaospring.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private CartaoCreditoRepository cartaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public TransacaoDTO create(CreateTransacaoDTO createTransacaoDTO) {
        Transacao entity = new Transacao();
        entity.setCartao(cartaoRepository.getOne(createTransacaoDTO.getIdCartao()));
        entity.setDataHora(createTransacaoDTO.getDataHora());
        entity.setDescricao(createTransacaoDTO.getDescricao());
        entity.setValor(createTransacaoDTO.getValor());

        return new TransacaoDTO(repository.save(entity));
    }

    @Override
    public TransacaoDTO update(Integer id, CreateTransacaoDTO createTransacaoDTO) {
        Transacao entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setDataHora(ofNullable(createTransacaoDTO.getDataHora()).orElse(entity.getDataHora()));
        entity.setDescricao(ofNullable(createTransacaoDTO.getDescricao()).orElse(entity.getDescricao()));
        entity.setValor(ofNullable(createTransacaoDTO.getValor()).orElse(entity.getValor()));

        return new TransacaoDTO(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<TransacaoDTO> list(Integer alunoId) {
        return cartaoRepository.findByAlunoId(alunoId).stream()
                .flatMap(c -> c.getTransacoes().stream())
                .map(TransacaoDTO::new)
                .collect(Collectors.toList());
    }


}
