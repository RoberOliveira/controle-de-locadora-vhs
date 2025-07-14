package br.edu.ifpr.locadora.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpr.locadora.demo.entidades.Usuario;
import br.edu.ifpr.locadora.demo.servicos.UserService;
import jakarta.validation.Valid;

@Controller
public class CadastroController {

    @Autowired
    private UserService userService;

    @GetMapping("/cadastro")
    public String showCadastroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String processCadastro(@Valid @ModelAttribute("usuario") Usuario usuario,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        userService.save(usuario);
        return "redirect:/login?cadastroSucesso";
    }
}
