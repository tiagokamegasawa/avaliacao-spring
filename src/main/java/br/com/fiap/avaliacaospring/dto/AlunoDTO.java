package br.com.fiap.avaliacaospring.dto;

import br.com.fiap.avaliacaospring.entity.Aluno;

public class AlunoDTO {

    private Integer id;

    private String nome;

    private String rm;

    private String turma;

    public AlunoDTO(Aluno entity) {
        this(entity.getId(), entity.getNome(), entity.getRm(), entity.getTurma());
    }

    public AlunoDTO(Integer id, String nome, String rm, String turma) {
        this.id = id;
        this.nome = nome;
        this.rm = rm;
        this.turma = turma;
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
