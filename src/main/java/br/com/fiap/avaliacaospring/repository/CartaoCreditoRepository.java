package br.com.fiap.avaliacaospring.repository;

import br.com.fiap.avaliacaospring.entity.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Integer> {
    List<CartaoCredito> findByAlunoId(Integer alunoId);
}
