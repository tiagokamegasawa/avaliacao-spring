package br.com.fiap.avaliacaospring.dto;

import br.com.fiap.avaliacaospring.entity.CartaoCredito;

import java.util.List;
import java.util.stream.Collectors;

public class CartaoCreditoDTO {

    private Integer id;

    private String ultimosDigitos;

    private List<TransacaoDTO> transacoes;

    private AlunoDTO aluno;

    public CartaoCreditoDTO() {
    }

    public CartaoCreditoDTO(CartaoCredito cartaoCredito) {
        this.id = cartaoCredito.getId();
        this.ultimosDigitos = cartaoCredito.getUltimosDigitos();
        this.transacoes = cartaoCredito.getTransacoes().stream().map(TransacaoDTO::new).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUltimosDigitos() {
        return ultimosDigitos;
    }

    public void setUltimosDigitos(String ultimosDigitos) {
        this.ultimosDigitos = ultimosDigitos;
    }

    public List<TransacaoDTO> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<TransacaoDTO> transacoes) {
        this.transacoes = transacoes;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }
}
