package br.com.fiap.avaliacaospring.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACAO")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private CartaoCredito cartao;

    @Column
    private LocalDateTime dataHora;

    @Column
    private Double valor;

    @Column
    private String descricao;

    public Transacao() {
    }

    public Transacao(CartaoCredito cartao, LocalDateTime dataHora, Double valor, String descricao) {
        this.cartao = cartao;
        this.dataHora = dataHora;
        this.valor = valor;
        this.descricao = descricao;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartaoCredito getCartao() {
        return cartao;
    }

    public void setCartao(CartaoCredito cartao) {
        this.cartao = cartao;
    }

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
