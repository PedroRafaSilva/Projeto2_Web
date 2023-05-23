package com.example.projeto2_web.Classes.Oficina;

import com.example.projeto2_web.Classes.Oficina.Oficina;
import com.example.projeto2_web.Classes.Oficina.OficinaRepository;

import java.util.List;
import java.util.Optional;

public class OficinaService {
    private final OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public Oficina createOficina(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    public List<Oficina> getAllOficinaes() {
        return oficinaRepository.findAll();
    }

    public Optional<Oficina> getOficinaById(int id) {
        return oficinaRepository.findById(id);
    }

    public Oficina updateOficina(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    public void deleteOficina(int id) {
        oficinaRepository.deleteById(id);
    }

}
