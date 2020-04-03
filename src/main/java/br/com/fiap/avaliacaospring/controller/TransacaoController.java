package br.com.fiap.avaliacaospring.controller;

import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.TransacaoDTO;
import br.com.fiap.avaliacaospring.service.TransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @ApiOperation(value = "Realiza o cadastro de uma transação de um determinado cartão", consumes = "application/json", httpMethod = "POST")
    @ApiResponse(code = 201, message = "Transação criada com sucesso.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO create(@RequestBody CreateTransacaoDTO createTransacaoDTO) {
        return transacaoService.create(createTransacaoDTO);
    }

    @ApiOperation(value = "Realiza atualização de uma transação", consumes = "application/json", httpMethod = "PUT")
    @ApiResponse(code = 200, message = "Transação atualizada com sucesso.")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO update(@PathVariable Integer id, @RequestBody CreateTransacaoDTO createTransacaoDTO) {
        return transacaoService.update(id, createTransacaoDTO);
    }

    @ApiOperation(value = "Exclui uma transação", consumes = "application/json", httpMethod = "DELETE")
    @ApiResponse(code = 200, message = "Transação excluída com sucesso.")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        transacaoService.delete(id);
    }

    @ApiOperation(value = "Lista todas as transações para um aluno", consumes = "application/json", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Lista de transações obtida com sucesso.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoDTO> list(
            @RequestParam("alunoId")
            @ApiParam("Identificador do aluno")
                    Integer alunoId) {
        return transacaoService.list(alunoId);
    }

}
