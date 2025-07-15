package br.edu.ifpr.locadora.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpr.locadora.demo.entidades.Usuario;
import br.edu.ifpr.locadora.demo.servicos.UsuarioService; 

@Controller
public class CadastroController {


    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro"; 
    }

    @PostMapping("/cadastro")
    public String processCadastro(Usuario usuario, RedirectAttributes redirectAttributes) {
        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("successMessage", "Usuário cadastrado com sucesso! Faça o login.");
        return "redirect:/login";
    }
}