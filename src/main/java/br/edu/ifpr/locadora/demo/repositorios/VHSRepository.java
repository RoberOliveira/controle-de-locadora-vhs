package br.edu.ifpr.locadora.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpr.locadora.demo.entidades.VHS;

@Repository
public interface VHSRepository extends JpaRepository<VHS, Long> {}