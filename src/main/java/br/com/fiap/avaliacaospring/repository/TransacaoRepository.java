package br.com.fiap.avaliacaospring.repository;

import br.com.fiap.avaliacaospring.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {}
