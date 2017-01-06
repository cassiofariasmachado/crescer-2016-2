/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Ator;
import br.com.cwi.crescer.aula8.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cfari
 */
@RestController
@RequestMapping("/rest/ator")
public class AtorRest {

    @Autowired
    AtorService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Ator> list(Pageable pgbl) {
        return service.findAll(pgbl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ator save(@RequestBody Ator ator) {
        return service.save(ator);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Ator ator) {
        service.delete(ator.getId());
    }
}
