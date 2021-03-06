package br.com.fiap.avaliacaospring.dto;

import br.com.fiap.avaliacaospring.entity.Transacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TransacaoDTO {

    private Integer id;

    private Integer idCartaoCredito;

    private LocalDateTime dataHora;

    private Double valor;

    private String descricao;

    public TransacaoDTO(Transacao entity) {
        this.id = entity.getId();
        this.idCartaoCredito = entity.getCartao().getId();
        this.dataHora = entity.getDataHora();
        this.valor = entity.getValor();
        this.descricao = entity.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCartaoCredito() {
        return idCartaoCredito;
    }

    public void setIdCartaoCredito(Integer idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
