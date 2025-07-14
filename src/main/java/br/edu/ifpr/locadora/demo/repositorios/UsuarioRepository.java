package br.edu.ifpr.locadora.demo.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpr.locadora.demo.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
