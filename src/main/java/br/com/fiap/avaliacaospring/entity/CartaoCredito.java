package br.com.fiap.avaliacaospring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CARTAO_CREDITO")
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String ultimosDigitos;

    @OneToMany(mappedBy = "cartao")
    private List<Transacao> transacoes;

    @ManyToOne
    private Aluno aluno;

    public CartaoCredito() {
    }

    public CartaoCredito(String ultimosDigitos) {
        this.ultimosDigitos = ultimosDigitos;
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

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
