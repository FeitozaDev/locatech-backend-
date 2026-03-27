package br.com.fiap.locatech.locatech.controllers;


import br.com.fiap.locatech.locatech.entities.Pessoa;

import br.com.fiap.locatech.locatech.services.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping

    public ResponseEntity<List<Pessoa>> findAllPessoa(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("Foi acessado o endpoint de pessoa /pessoas");
        var pessoas = this.pessoaService.findAllPessoa(page, size);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findPessoas(
            @PathVariable("id") Long id
    ) {
        logger.info("/pessoa/" + id);
        var pessoa = this.pessoaService.findPessoaById(id);
        return ResponseEntity.ok(pessoa);
    }


    @PostMapping
    public ResponseEntity<Void> savePessoa(
            @RequestBody Pessoa pessoa
    ) {
        logger.info("POST ->/veiculos");
        this.pessoaService.savePessoa(pessoa);
        return ResponseEntity.status(201).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(

            @PathVariable("id") long id,
            @RequestBody Pessoa pessoa
    ) {
        logger.info("PUT ->/pessoas/" + id);
        this.pessoaService.updatePessoa(pessoa, id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(
            @PathVariable("id") Long id
    ){
        logger.info("DELETE ->/pessoas/" + id);
        this.pessoaService.delete(id);
        return ResponseEntity.ok().build();

    }

}



