package br.com.cwi.crescer.aula8.exercicios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
public class ExampleController {

    @RequestMapping(value = "/")
    String toIndex(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name != null ? name : "Cássio Farias Machado");
        return "index";
    }
}
