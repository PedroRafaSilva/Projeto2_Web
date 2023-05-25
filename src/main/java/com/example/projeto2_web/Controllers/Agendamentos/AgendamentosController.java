package com.example.projeto2_web.Controllers.Agendamentos;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.Agendamento.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AgendamentosController {
    @Autowired private AgendamentoService service;

    @GetMapping("/Agendamentos/{id}")
    public String showCalendar(@PathVariable("id") Integer id, Model model) {
        List<Agendamento> agendamentos = service.getAllAgendamentoes();
        model.addAttribute("agendamentos", agendamentos);
        model.addAttribute("id", id);
        return "/Agendamentos/Agendamentos";
    }


}
