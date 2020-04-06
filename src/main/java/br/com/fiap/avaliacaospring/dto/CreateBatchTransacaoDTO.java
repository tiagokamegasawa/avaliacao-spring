package br.com.fiap.avaliacaospring.dto;

import java.util.ArrayList;
import java.util.List;

public class CreateBatchTransacaoDTO {

    private Integer idAluno;

    private String ultimosDigitos;

    private List<CreateTransacaoDTO> transacoes = new ArrayList<>();

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getUltimosDigitos() {
        return ultimosDigitos;
    }

    public void setUltimosDigitos(String ultimosDigitos) {
        this.ultimosDigitos = ultimosDigitos;
    }

    public List<CreateTransacaoDTO> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<CreateTransacaoDTO> transacoes) {
        this.transacoes = transacoes;
    }
}
