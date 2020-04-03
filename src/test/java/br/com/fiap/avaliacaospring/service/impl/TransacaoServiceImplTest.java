package br.com.fiap.avaliacaospring.service.impl;

import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.TransacaoDTO;
import br.com.fiap.avaliacaospring.entity.CartaoCredito;
import br.com.fiap.avaliacaospring.entity.Transacao;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import br.com.fiap.avaliacaospring.repository.CartaoCreditoRepository;
import br.com.fiap.avaliacaospring.repository.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TransacaoServiceImplTest {

    @Mock
    private TransacaoRepository repository;

    @Mock
    private CartaoCreditoRepository cartaoRepository;

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private TransacaoServiceImpl transacaoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create() {
        CreateTransacaoDTO createTransacaoDTO = new CreateTransacaoDTO();
        Integer idCartao = 1;
        createTransacaoDTO.setIdCartao(idCartao);
        createTransacaoDTO.setDataHora(LocalDateTime.of(2020, 3, 31, 0, 0, 0));
        createTransacaoDTO.setDescricao("COMPRA ELO");
        createTransacaoDTO.setValor(25.0);
        when(cartaoRepository.getOne(idCartao)).thenReturn(new CartaoCredito(idCartao));
        when(repository.save(any())).thenAnswer((Answer<Transacao>) invocation -> (Transacao) invocation.getArguments()[0]);

        TransacaoDTO transacaoDTO = this.transacaoService.create(createTransacaoDTO);
        assertEquals(createTransacaoDTO.getIdCartao(), transacaoDTO.getIdCartaoCredito());
        assertEquals(createTransacaoDTO.getDataHora(), transacaoDTO.getDataHora());
        assertEquals(createTransacaoDTO.getDescricao(), transacaoDTO.getDescricao());
        assertEquals(createTransacaoDTO.getValor(), transacaoDTO.getValor());
    }

    @Test
    public void update() {
        CreateTransacaoDTO createTransacaoDTO = new CreateTransacaoDTO();
        Integer idCartao = 1;
        createTransacaoDTO.setIdCartao(idCartao);
        createTransacaoDTO.setDataHora(LocalDateTime.of(2020, 3, 31, 0, 0, 0));
        createTransacaoDTO.setDescricao("COMPRA ELO");
        createTransacaoDTO.setValor(25.0);
        when(cartaoRepository.getOne(idCartao)).thenReturn(new CartaoCredito(idCartao));
        when(repository.save(any())).thenAnswer((Answer<Transacao>) invocation -> (Transacao) invocation.getArguments()[0]);

        TransacaoDTO transacaoDTO = this.transacaoService.create(createTransacaoDTO);
        assertEquals(createTransacaoDTO.getIdCartao(), transacaoDTO.getIdCartaoCredito());
        assertEquals(createTransacaoDTO.getDataHora(), transacaoDTO.getDataHora());
        assertEquals(createTransacaoDTO.getDescricao(), transacaoDTO.getDescricao());
        assertEquals(createTransacaoDTO.getValor(), transacaoDTO.getValor());
    }

    @Test
    public void delete() {
        Integer idTransacao = 1;
        this.transacaoService.delete(idTransacao);
        verify(this.repository).deleteById(idTransacao);
    }

    @Test
    public void list() {
        Integer alunoId = 1;
        CartaoCredito cartao = new CartaoCredito();
        Transacao transacao = new Transacao(cartao, LocalDateTime.now(), 50.0, "COMPRA ELO");
        cartao.getTransacoes().add(transacao);
        when(cartaoRepository.findByAlunoId(alunoId)).thenReturn(Stream.of(cartao).collect(toList()));

        List<TransacaoDTO> results = this.transacaoService.list(alunoId);
        assertEquals(1, results.size());
        assertEquals(transacao.getDataHora(), results.get(0).getDataHora());
        assertEquals(transacao.getValor(), results.get(0).getValor());
        assertEquals(transacao.getDescricao(), results.get(0).getDescricao());
    }
}
