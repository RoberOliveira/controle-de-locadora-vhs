package br.edu.ifpr.locadora.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Garanta que a importação da entidade Category esteja correta
import br.edu.ifpr.locadora.demo.entidades.Category;

@Repository
// A interface deve estender JpaRepository usando a ENTIDADE Category
public interface CategoryRepository extends JpaRepository<Category, Long> {
}