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

    public Utilizador getUtilizadorById(int id) {
        if (utilizadorRepository.findById(id).isPresent()) {
            return utilizadorRepository.findById(id).get();
        } else {
           return null;
        }
    }

    public Utilizador updateUtilizador(Utilizador utilizador) {
        return utilizadorRepository.save(utilizador);
    }

    public void deleteUtilizador(int id) {
        utilizadorRepository.deleteById(id);
    }

    public Utilizador findByUsername(String username){
        return utilizadorRepository.findByUsername(username);
    }

    public boolean verifyCredentials(String username, String password) {
        Utilizador user = utilizadorRepository.findByUsername(username);

        return user != null && user.getPassword().equals(password) && user.getIdtipoutilizador() == 3;
    }

    public String validateUser(Utilizador utilizador, int id){
        boolean hasLettters = false;


        if (!utilizador.getEmail().contains("@") || !utilizador.getEmail().contains(".com"))  {
            return "O email deve ser do tipo: joao@algo.com!";
        }

       if (utilizador.getTelefone().length() != 9){
            return "O número de telefone apenas deve ter 9 números!";
        }

        if (utilizador.getNif() > 1000000000 || utilizador.getNif() < 1000000) {
            return "O NIF deve ter no máximo 10 números!";
        }

        if (utilizador.getCpostal().length() < 7 || !utilizador.getCpostal().equals(utilizador.getCpostal().substring(0, 4) + "-" + utilizador.getCpostal().substring(5))) {
            return "O codígo de Postal deve ser do tipo: 1234-123.";
        }

        if(findByUsername(utilizador.getUsername()) != null && findByUsername(utilizador.getUsername()).getIdutilizador() != id)
            if (!verifyCredentials(utilizador.getUsername(), utilizador.getPassword())) {
                return "Escolha outro username ou palavra-passe.";
        }

        return "OK";
    }




}
