package br.edu.ifpr.locadora.demo.servicos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpr.locadora.demo.entidades.VHS;
import br.edu.ifpr.locadora.demo.repositorios.VHSRepository;

@Service
public class VHSService {

    @Autowired
    private VHSRepository vhsRepository;

    public List<VHS> findAll() {
        return vhsRepository.findAll();
    }

    public Optional<VHS> findById(Long id) {
        return vhsRepository.findById(id);
    }

    public VHS save(VHS vhs) {
        return vhsRepository.save(vhs);
    }

    public void deleteById(Long id) {
        vhsRepository.deleteById(id);
    }
}