package com.example.projeto2_web.Classes.Fatura;

import com.example.projeto2_web.Classes.Fatura.Fatura;
import com.example.projeto2_web.Classes.Fatura.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public Fatura createFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> getAllFaturaes() {
        return faturaRepository.findAll();
    }

    public Optional<Fatura> getFaturaById(int id) {
        return faturaRepository.findById(id);
    }

    public Fatura updateFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public void deleteFatura(int id) {
        faturaRepository.deleteById(id);
    }

}
