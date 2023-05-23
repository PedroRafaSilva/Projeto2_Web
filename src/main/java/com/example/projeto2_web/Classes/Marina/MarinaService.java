package com.example.projeto2_web.Classes.Marina;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MarinaService {
    private final MarinaRepository marinaRepository;

    public MarinaService(MarinaRepository marinaRepository) {
        this.marinaRepository = marinaRepository;
    }

    public Marina createMarina(Marina marina) {
        return marinaRepository.save(marina);
    }

    public List<Marina> getAllMarinaes() {
        return marinaRepository.findAll();
    }

    public Optional<Marina> getMarinaById(int id) {
        return marinaRepository.findById(id);
    }

    public Marina updateMarina(Marina marina) {
        return marinaRepository.save(marina);
    }

    public void deleteMarina(int id) {
        marinaRepository.deleteById(id);
    }

}
