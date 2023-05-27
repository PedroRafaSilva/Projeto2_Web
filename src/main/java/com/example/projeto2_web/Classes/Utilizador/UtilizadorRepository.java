package com.example.projeto2_web.Classes.Utilizador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Integer> {
    Utilizador findByUsername(String username);

}