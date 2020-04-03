package br.com.fiap.avaliacaospring.dto;

import br.com.fiap.avaliacaospring.entity.CartaoCredito;

import java.util.List;
import java.util.stream.Collectors;

public class ExtratoAlunoDTO {

    private final List<CartaoCreditoDTO> cartoes;

    public ExtratoAlunoDTO(List<CartaoCredito> cartoes) {
        this.cartoes = cartoes.stream().map(CartaoCreditoDTO::new).collect(Collectors.toList());
    }

    public List<CartaoCreditoDTO> getCartoes() {
        return cartoes;
    }
}
