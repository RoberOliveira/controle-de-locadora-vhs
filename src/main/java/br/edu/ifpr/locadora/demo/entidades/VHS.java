package br.edu.ifpr.locadora.demo.entidades;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty; // Importar
import jakarta.validation.constraints.NotNull;   // Importar
import lombok.Data;

@Entity
@Data
public class VHS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O título não pode ser vazio.")
    private String title;
    
    @NotEmpty(message = "O nome do diretor não pode ser vazio.")
    private String director;
    
    private String imageUrl; // Opcional, sem validação

    @NotNull(message = "A data de cadastro é obrigatória.")
    private LocalDate registrationDate;

    @NotNull(message = "A categoria é obrigatória.")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull(message = "O status é obrigatório.")
    @Enumerated(EnumType.STRING)
    private TapeStatus status;
}