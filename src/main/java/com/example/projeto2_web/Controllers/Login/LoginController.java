package com.example.projeto2_web.Controllers.Login;

import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import com.example.projeto2_web.Classes.Utilizador.UtilizadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {
    @Autowired private UtilizadorService service;

    @GetMapping("/Login")
    public String showLogin(Model model){
        return "/Login/Login";
    }

    @PostMapping("/validate")
    public String validateCredentials(@RequestParam("username") String username,
                                      @RequestParam("password") String password) {
        boolean isValidCredentials = service.verifyCredentials(username, password);
        if (isValidCredentials) {
            // Authentication successful
            return "redirect:/Home";
        } else {
            // Authentication failed
            return "redirect:/Login/Login";
        }
    }
}
