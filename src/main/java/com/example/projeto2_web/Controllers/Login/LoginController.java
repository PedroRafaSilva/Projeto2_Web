package com.example.projeto2_web.Controllers.Login;

import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import com.example.projeto2_web.Classes.Utilizador.UtilizadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "loginForm") Utilizador login, Model model) {
        String username = login.getUsername();
        String password = login.getPassword();

        if (service.verifyCredentials(username, password)) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "redirect:/Home";
        } else {
            model.addAttribute("error", "Incorrect username or password");
            return "redirect:/Login?error";
        }
    }

}
