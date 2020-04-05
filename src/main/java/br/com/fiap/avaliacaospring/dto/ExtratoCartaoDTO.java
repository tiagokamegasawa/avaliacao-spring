package br.com.fiap.avaliacaospring.dto;

import br.com.fiap.avaliacaospring.entity.CartaoCredito;

import java.util.List;
import java.util.stream.Collectors;

public class ExtratoCartaoDTO {

    private Integer idCartao;

    private String ultimosDigitos;

    private List<TransacaoDTO> transacoes;

    public ExtratoCartaoDTO() {
    }

    public ExtratoCartaoDTO(CartaoCredito cartaoCredito) {
        this.idCartao = cartaoCredito.getId();
        this.ultimosDigitos = cartaoCredito.getUltimosDigitos();
        this.transacoes = cartaoCredito.getTransacoes().stream().map(TransacaoDTO::new).collect(Collectors.toList());
    }

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
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
}