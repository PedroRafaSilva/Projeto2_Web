package com.example.projeto2_web.Classes.CodPostal;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodPostalService {

    private final CodPostalRepository codPostalRepository;

    public CodPostalService(CodPostalRepository codPostalRepository) {
        this.codPostalRepository = codPostalRepository;
    }

    public CodPostal createCodPostal(CodPostal codPostal) {
        return codPostalRepository.save(codPostal);
    }

    public List<CodPostal> getAllCodPostales() {
        return codPostalRepository.findAll();
    }

    public Optional<CodPostal> getCodPostalById(String id) {
        return codPostalRepository.findById(id);
    }

    public CodPostal updateCodPostal(CodPostal codPostal) {
        return codPostalRepository.save(codPostal);
    }

    public void deleteCodPostal(String id) {
        codPostalRepository.deleteById(id);
    }

}
