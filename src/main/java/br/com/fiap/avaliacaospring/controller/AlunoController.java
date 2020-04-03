package br.com.fiap.avaliacaospring.controller;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateCartaoCreditoDTO;
import br.com.fiap.avaliacaospring.dto.ExtratoAlunoDTO;
import br.com.fiap.avaliacaospring.service.AlunoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @ApiOperation(value = "Realiza o cadastro de um aluno", consumes = "application/json", httpMethod = "POST")
    @ApiResponse(code = 201, message = "Cadastro de aluno realizado com sucesso.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO create(@RequestBody CreateAlunoDTO createAlunoDTO) {
        return alunoService.create(createAlunoDTO);
    }

    @ApiOperation(value = "Atualiza o cadastro de um aluno", consumes = "application/json", httpMethod = "PUT")
    @ApiResponse(code = 201, message = "Atualização realizada com sucesso.")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO update(
            @PathVariable Integer id,
            @RequestBody CreateAlunoDTO createAlunoDTO) {
        return alunoService.update(id, createAlunoDTO);
    }

    @ApiOperation(value = "Adiciona um cartão para o aluno", consumes = "application/json", httpMethod = "PATCH")
    @ApiResponse(code = 200, message = "Cartão adicionado com sucesso.")
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoDTO update(
            @PathVariable Integer id,
            @RequestBody CreateCartaoCreditoDTO cartaoDTO) {
        return alunoService.update(id, cartaoDTO);
    }

    @ApiOperation(value = "Exclui um aluno", consumes = "application/json", httpMethod = "DELETE")
    @ApiResponse(code = 200, message = "Aluno excluído com sucesso.")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        alunoService.delete(id);
    }

    @ApiOperation(value = "Lista todos os alunos", consumes = "application/json", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Listagem de alunos realizada com sucesso.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoDTO> list() {
        return alunoService.list();
    }

    @ApiOperation(value = "Obtém o extrato de um aluno", consumes = "application/json", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Extrato obtido com sucesso.")
    @GetMapping("{id}/extrato")
    @ResponseStatus(HttpStatus.OK)
    public ExtratoAlunoDTO extrato(@PathVariable Integer id) {
        return this.alunoService.extrato(id);
    }
}
