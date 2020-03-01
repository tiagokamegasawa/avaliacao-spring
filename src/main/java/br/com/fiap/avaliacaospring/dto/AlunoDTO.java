package br.com.fiap.avaliacaospring.dto;

import br.com.fiap.avaliacaospring.entity.Aluno;

public class AlunoDTO {

    private Integer id;

    private String nome;

    private String rm;

    private String turma;

    public AlunoDTO(Aluno entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.rm = entity.getRm();
        this.turma = entity.getTurma();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
