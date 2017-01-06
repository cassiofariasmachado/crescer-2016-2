/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Ator;
import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.AtorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author cfari
 */
@Controller
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    AtorService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }

        Ator ator = new Ator();
        model.addAttribute("ator", ator);
        model.addAttribute("atores", service.findAll(pageable));
        return "ator";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Ator ator, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(ator);
            return "redirect:ator";
        }
        return "ator";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Ator> atores = service.findAll(pageable);
        model.addAttribute("atores", atores);
        return "atores";
    }

    @RequestMapping(value = "/listarAtores", method = RequestMethod.GET)
    public String listarPessoas(Model model, Pageable pageable) {
        Page<Ator> pessoas = service.findAll(pageable);
        model.addAttribute("atores", pessoas);
        return "listagem-atores";
    }
}
