package com.example.projeto2_web.Controllers.Register;

import com.example.projeto2_web.Classes.CodPostal.CodPostal;
import com.example.projeto2_web.Classes.CodPostal.CodPostalService;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import com.example.projeto2_web.Classes.Utilizador.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UtilizadorService service;
    @Autowired
    private CodPostalService codPostalService;

    @GetMapping("/Register")
    public String showLogin(Model model){
        model.addAttribute("utilizador", new Utilizador());
        return "/Register/Register";
    }

    @PostMapping("/save")
    public String validate(Utilizador utilizador, Model model, @RequestParam("cpostal") String codPostal, @RequestParam("localidade") String localidade) {
        String validation = service.validateUser(utilizador, 0);
        if (validation.equals("OK")) {
            if(codPostalService.getCodPostalById(codPostal) != null){
                CodPostal codPostal1 = new CodPostal();
                codPostal1.setCpostal(codPostal);
                codPostal1.setLocalidade(localidade);
                codPostalService.createCodPostal(codPostal1);
            }
            utilizador.setIdtipoutilizador(3);
            service.createUtilizador(utilizador);
            return "redirect:/Login";
        }
        model.addAttribute("error", validation);
        model.addAttribute("utilizador", utilizador);
        return "/Register/Register";
    }
}
