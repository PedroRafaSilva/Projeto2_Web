package com.example.projeto2_web.Controllers.Perfil;

import com.example.projeto2_web.Classes.CodPostal.CodPostal;
import com.example.projeto2_web.Classes.CodPostal.CodPostalService;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import com.example.projeto2_web.Classes.Utilizador.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PerfilController {

    @Autowired private UtilizadorService service;
    @Autowired private CodPostalService codPostalService;

    @GetMapping("/Perfil/{id}")
    public String showPerfil(@PathVariable("id") Integer id, Model model) {
        Utilizador utilizador = service.getUtilizadorById(id);
        model.addAttribute("id", id);
        model.addAttribute("utilizador", utilizador);
        model.addAttribute("codpostal", codPostalService.getCodPostalById(utilizador.getCpostal()));
        return "/Perfil/Perfil";
    }

    @PostMapping("/validate/{id}")
    public String validate(@PathVariable("id") Integer id, Utilizador utilizador, Model model, @ModelAttribute("codpostal") CodPostal codpostal) {
        String validation = service.validateUser(utilizador);
        if (validation.equals("OK")) {
            if(codpostal != null){
                codPostalService.createCodPostal(codpostal);
            }
            utilizador.setIdutilizador(id);
            utilizador.setIdtipoutilizador(3);
            service.updateUtilizador(utilizador);
            return "redirect:/Perfil/{id}";
        }
        model.addAttribute("error", validation);
        model.addAttribute("utilizador", utilizador);
        return "/Perfil/Perfil";
    }
}
