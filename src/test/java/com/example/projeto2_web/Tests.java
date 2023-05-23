package com.example.projeto2_web;


import com.example.projeto2_web.Classes.Utilizador.UtilizadorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Tests {
    @Autowired private UtilizadorRepository rep;

    @Test
    public void teste(){
        System.out.println(rep.findByUsername("Pedro").getNome());
    }
}
