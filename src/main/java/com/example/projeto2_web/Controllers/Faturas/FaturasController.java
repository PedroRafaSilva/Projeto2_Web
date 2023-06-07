package com.example.projeto2_web.Controllers.Faturas;

import com.example.projeto2_web.Classes.Fatura.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FaturasController {
    @Autowired
    private FaturaService service;

    @GetMapping("/Faturas/{id}")
    public String showCalendar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("faturas", service.getAllFaturasGenerated(id));
        model.addAttribute("id", id);
        return "/Faturas/Faturas";
    }
}
