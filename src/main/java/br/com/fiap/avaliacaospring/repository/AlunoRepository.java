package br.com.fiap.avaliacaospring.repository;

import br.com.fiap.avaliacaospring.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
