package br.com.minhamepresa.app_de_recados.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("nome", "Alexandre");
        return "home/recados/index";
    }
}
