package br.com.fiap.avaliacaospring.service.impl;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;
import br.com.fiap.avaliacaospring.dto.ExtratoAlunoDTO;
import br.com.fiap.avaliacaospring.entity.Aluno;
import br.com.fiap.avaliacaospring.entity.CartaoCredito;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import br.com.fiap.avaliacaospring.repository.CartaoCreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AlunoServiceImplTest {

    @Mock
    private AlunoRepository alunoRepository;

    @Mock
    private CartaoCreditoRepository cartaoRepository;

    @InjectMocks
    private AlunoServiceImpl alunoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create() {
        CreateAlunoDTO createAlunoDTO = new CreateAlunoDTO();

        createAlunoDTO.setNome("Gabriel Gabes");
        createAlunoDTO.setRm("333454");
        createAlunoDTO.setTurma("34scj");
        when(alunoRepository.save(any())).thenAnswer((Answer<Aluno>) invocation -> (Aluno) invocation.getArguments()[0]);

        AlunoDTO alunoDTO = this.alunoService.create(createAlunoDTO);
        assertEquals(createAlunoDTO.getNome(), alunoDTO.getNome());
        assertEquals(createAlunoDTO.getRm(), alunoDTO.getRm());
        assertEquals(createAlunoDTO.getTurma(), alunoDTO.getTurma());
    }

    @Test
    public void update() {
        Integer id = 1;
        CreateAlunoDTO createAlunoDTO = new CreateAlunoDTO();
        createAlunoDTO.setNome("Gabriel Gabes da Silva");
        Aluno entity = new Aluno();
        entity.setId(id);
        entity.setNome("Gabes Gabriel");
        when(alunoRepository.findById(id)).thenReturn(Optional.of(entity));
        when(alunoRepository.save(any())).thenAnswer((Answer<Aluno>) invocation -> (Aluno) invocation.getArguments()[0]);

        AlunoDTO updated = this.alunoService.update(id, createAlunoDTO);

        assertEquals(createAlunoDTO.getNome(), updated.getNome());
    }

    @Test
    public void delete() {
        Integer id = 1;
        this.alunoService.delete(id);
        verify(alunoRepository).deleteById(id);
    }

    @Test
    public void list() {
        this.alunoService.list();
        verify(alunoRepository).findAllDTO();
    }

    @Test
    public void extrato() {
        Integer id = 1;
        Aluno aluno = new Aluno();
        CartaoCredito cartaoCredito = new CartaoCredito("1234", aluno);
        aluno.getCartoes().add(cartaoCredito);
        when(alunoRepository.findById(id)).thenReturn(Optional.of(aluno));
        ExtratoAlunoDTO extrato = this.alunoService.extrato(id);
        assertEquals(1, extrato.getCartoes().size());
        assertEquals(cartaoCredito.getUltimosDigitos(), extrato.getCartoes().get(0).getUltimosDigitos());
    }

}
