package br.edu.ifpr.locadora.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    /**
     * Lista todas as fitas VHS
     */
    @GetMapping
    public String findAll(Model model) {
        List<VHS> vhsList = vhsService.findAll();
        model.addAttribute("vhsList", vhsList);
        return "vhs-list";
    }

    /**
     * Exibe o formulário para cadastrar uma nova VHS
     */
    @GetMapping("/novo")
    public String showNewVhsForm(Model model) {
        model.addAttribute("vhs", new VHS());
        model.addAttribute("allCategories", categoryService.findAll());
        return "vhs-form";
    }

    /**
     * Salva uma nova VHS ou atualiza uma existente, com validação
     */
    @PostMapping("/salvar")
    public String saveVhs(
            @Valid @ModelAttribute("vhs") VHS vhs,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            // Se houver erros de validação, recarrega categorias e volta ao formulário
            model.addAttribute("allCategories", categoryService.findAll());
            return "vhs-form";
        }

        vhsService.save(vhs);
        return "redirect:/vhs";
    }

    /**
     * Exibe o formulário para editar uma VHS existente
     */
    @GetMapping("/editar/{id}")
    public String showEditVhsForm(@PathVariable Long id, Model model) {
        VHS vhs = vhsService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da Fita inválido: " + id));

        model.addAttribute("vhs", vhs);
        model.addAttribute("allCategories", categoryService.findAll());
        return "vhs-form";
    }

    /**
     * Deleta uma VHS pelo ID
     */
    @GetMapping("/deletar/{id}")
    public String deleteVhs(@PathVariable Long id) {
        vhsService.deleteById(id);
        return "redirect:/vhs";
    }
}
