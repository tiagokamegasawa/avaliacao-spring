package br.com.fiap.avaliacaospring.repository;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("SELECT new br.com.fiap.avaliacaospring.dto.AlunoDTO(a.id, a.nome, a.rm, a.turma) from Aluno a")
    List<AlunoDTO> findAllDTO();

}
