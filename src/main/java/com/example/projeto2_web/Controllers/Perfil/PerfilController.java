package com.example.projeto2_web.Controllers.Perfil;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import com.example.projeto2_web.Classes.Utilizador.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Controller
public class PerfilController {

    @Autowired private UtilizadorService service;

    @GetMapping("/Perfil/{id}")
    public String showCalendar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "/Perfil/Perfil";
    }
}
