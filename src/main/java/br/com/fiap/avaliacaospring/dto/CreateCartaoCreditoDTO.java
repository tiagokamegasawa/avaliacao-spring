package br.com.fiap.avaliacaospring.dto;

public class CreateCartaoCreditoDTO {

    private String ultimosDigitos;

    public String getUltimosDigitos() {
        return ultimosDigitos;
    }

    public void setUltimosDigitos(String ultimosDigitos) {
        this.ultimosDigitos = ultimosDigitos;
    }

    public CreateCartaoCreditoDTO() {
    }

    public CreateCartaoCreditoDTO(String ultimosDigitos) {
        this.ultimosDigitos = ultimosDigitos;
    }
}
