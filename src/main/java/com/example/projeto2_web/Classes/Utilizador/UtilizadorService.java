package com.example.projeto2_web.Classes.Utilizador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilizadorService {
    private final UtilizadorRepository utilizadorRepository;

    public UtilizadorService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    public Utilizador createUtilizador(Utilizador utilizador) {
        return utilizadorRepository.save(utilizador);
    }

    public List<Utilizador> getAllUtilizadores() {
        return utilizadorRepository.findAll();
    }

    public Optional<Utilizador> getUtilizadorById(int id) {
        return utilizadorRepository.findById(id);
    }

    public Utilizador updateUtilizador(Utilizador utilizador) {
        return utilizadorRepository.save(utilizador);
    }

    public void deleteUtilizador(int id) {
        utilizadorRepository.deleteById(id);
    }

    public boolean verifyCredentials(String username, String password) {
        Utilizador user = utilizadorRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password) && user.getIdtipoutilizador() == 3) {
            return true;
        }

        return false;
    }

}
