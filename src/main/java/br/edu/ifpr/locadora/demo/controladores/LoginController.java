package br.edu.ifpr.locadora.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "login"; // Retorna o nome do arquivo HTML de login
    }
}