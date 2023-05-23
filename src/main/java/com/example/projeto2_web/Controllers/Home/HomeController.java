package com.example.projeto2_web.Controllers.Home;

import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/Home")
    public String showLogin(){
        return "/Home/Home";
    }
}
