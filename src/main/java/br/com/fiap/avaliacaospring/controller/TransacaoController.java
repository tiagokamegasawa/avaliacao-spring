package br.com.fiap.avaliacaospring.controller;

import br.com.fiap.avaliacaospring.dto.CreateTransacaoDTO;
import br.com.fiap.avaliacaospring.dto.TransacaoDTO;
import br.com.fiap.avaliacaospring.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO create(@RequestBody CreateTransacaoDTO createTransacaoDTO) {
        return transacaoService.create(createTransacaoDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO update(@PathVariable Integer id, @RequestBody CreateTransacaoDTO createTransacaoDTO) {
        return transacaoService.update(id, createTransacaoDTO);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        transacaoService.delete(id);
    }

    @GetMapping
    public List<TransacaoDTO> list(@RequestParam("alunoId") Integer alunoId) {
        return transacaoService.list(alunoId);
    }

}
