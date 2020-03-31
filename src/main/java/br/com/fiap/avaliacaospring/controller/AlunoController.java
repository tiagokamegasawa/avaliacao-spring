package br.com.fiap.avaliacaospring.controller;

import br.com.fiap.avaliacaospring.dto.AlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateAlunoDTO;
import br.com.fiap.avaliacaospring.dto.CreateCartaoCreditoDTO;
import br.com.fiap.avaliacaospring.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO create(@RequestBody CreateAlunoDTO createAlunoDTO) {
        return alunoService.create(createAlunoDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO update(@PathVariable Integer id, @RequestBody CreateAlunoDTO createAlunoDTO) {
        return alunoService.update(id, createAlunoDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO update(@PathVariable Integer id, @RequestBody CreateCartaoCreditoDTO cartaoDTO) {
        return alunoService.update(id, cartaoDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {

        alunoService.delete(id);
    }

    @GetMapping
    public List<AlunoDTO> list() {
        return alunoService.list();
    }

}
