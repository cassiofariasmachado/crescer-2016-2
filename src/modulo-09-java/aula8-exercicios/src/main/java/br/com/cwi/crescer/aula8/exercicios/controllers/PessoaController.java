/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.exercicios.controllers;

import br.com.cwi.crescer.aula8.exercicios.entities.Pessoa;
import br.com.cwi.crescer.aula8.exercicios.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cassio.machado
 */
@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/pessoa", method = GET)
    public Iterable<Pessoa> pessoas() {
        return pessoaService.list();
    }

    @RequestMapping(value = "/pessoa", method = POST)
    public Iterable<Pessoa> pessoas(@RequestBody Pessoa pessoa) {
        pessoaService.add(pessoa);
        return pessoaService.list();
    }
}
