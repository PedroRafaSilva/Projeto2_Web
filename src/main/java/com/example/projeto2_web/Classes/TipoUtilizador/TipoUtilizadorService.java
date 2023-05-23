package com.example.projeto2_web.Classes.TipoUtilizador;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUtilizadorService {
    private final TipoUtilizadorRepository tipoUtilizadorRepository;

    public TipoUtilizadorService(TipoUtilizadorRepository tipoUtilizadorRepository) {
        this.tipoUtilizadorRepository = tipoUtilizadorRepository;
    }

    public TipoUtilizador createTipoUtilizador(TipoUtilizador tipoUtilizador) {
        return tipoUtilizadorRepository.save(tipoUtilizador);
    }

    public List<TipoUtilizador> getAllTipoUtilizadores() {
        return tipoUtilizadorRepository.findAll();
    }

    public Optional<TipoUtilizador> getTipoUtilizadorById(int id) {
        return tipoUtilizadorRepository.findById(id);
    }

    public TipoUtilizador updateTipoUtilizador(TipoUtilizador tipoUtilizador) {
        return tipoUtilizadorRepository.save(tipoUtilizador);
    }

    public void deleteTipoUtilizador(int id) {
        tipoUtilizadorRepository.deleteById(id);
    }

}
