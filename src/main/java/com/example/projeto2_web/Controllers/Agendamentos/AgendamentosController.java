package com.example.projeto2_web.Controllers.Agendamentos;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.Agendamento.AgendamentoService;
import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamento;
import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class AgendamentosController {
    @Autowired private AgendamentoService service;

    @GetMapping("/Agendamentos/{id}")
    public String showCalendar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("agendamentos", service.findAgendamentosByUtilizadorOrderByData(id));
        model.addAttribute("id", id);
        return "/Agendamentos/Agendamentos";
    }




}
