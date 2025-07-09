package br.edu.ifpr.locadora.demo.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpr.locadora.demo.entidades.VHS;
import br.edu.ifpr.locadora.demo.servicos.CategoryService;
import br.edu.ifpr.locadora.demo.servicos.VHSService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/vhs")
public class VHSController {

    @Autowired
    private VHSService vhsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String findAll(Model model) {
        List<VHS> vhsList = vhsService.findAll();
        model.addAttribute("vhsList", vhsList);
        return "vhs-list";
    }

    @GetMapping("/novo")
    public String showNewVhsForm(Model model) {
        model.addAttribute("allCategories", categoryService.findAll());
        model.addAttribute("vhs", new VHS());
        return "vhs-form";
    }

    @PostMapping("/salvar")
    public String saveVhs(@Valid VHS vhs, BindingResult bindingResult, Model model) {
        
        // Se houver erros de validação...
        if (bindingResult.hasErrors()) {
            // Recarregamos a lista de categorias para o formulário não quebrar
            model.addAttribute("allCategories", categoryService.findAll());
            // Retornamos para a página do formulário para exibir os erros
            return "vhs-form";
        }
        
        // Se não houver erros, salvamos e redirecionamos
        vhsService.save(vhs);
        return "redirect:/vhs";
    }

    @GetMapping("/editar/{id}")
    public String showEditVhsForm(@PathVariable Long id, Model model) {
        VHS vhs = vhsService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da Fita inválido:" + id));
        model.addAttribute("allCategories", categoryService.findAll());
        model.addAttribute("vhs", vhs);
        return "vhs-form";
    }

    @GetMapping("/deletar/{id}")
    public String deleteVhs(@PathVariable Long id) {
        vhsService.deleteById(id);
        return "redirect:/vhs";
    }
}