package com.example.projeto2_web.Controllers.Embarcacoes;

import com.example.projeto2_web.Classes.CodPostal.CodPostal;
import com.example.projeto2_web.Classes.Comprimento.ComprimentoService;
import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.Embarcacao.EmbarcacaoService;
import com.example.projeto2_web.Classes.Marina.MarinaService;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import com.example.projeto2_web.Classes.Utilizador.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmbarcacoesController {
    @Autowired
    private EmbarcacaoService service;
    @Autowired
    private UtilizadorService utilizadorService;
    @Autowired
    private MarinaService marinaService;
    @Autowired
    private ComprimentoService comprimentoService;

    @GetMapping("/Embarcacoes/{id}")
    public String showCalendar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("embarcacoes", service.findEmbarcacaosByUtilizadorByIdutilizadorOrderByNome(utilizadorService.getUtilizadorById(id)));
        model.addAttribute("marinas", marinaService.getAllMarinaes());
        model.addAttribute("comprimentos", comprimentoService.getAllComprimentoes());
        model.addAttribute("embarcacao", new Embarcacao());
        model.addAttribute("id", id);
        return "/Embarcacoes/Embarcacoes";
    }

    @PostMapping("/validateEmb/{id}")
    public String validateEmb(@PathVariable("id") Integer id, Embarcacao embarcacao, Model model) {
        embarcacao.setIdutilizador(id);
        service.createEmbarcacao(embarcacao);
        return "redirect:/Embarcacoes/{id}";
    }

    @GetMapping("/deleteEmb/{id}")
    public String deleteEmb(@PathVariable("id") Integer id, Integer idEmb) {
        service.deleteEmbarcacao(idEmb);
        return "redirect:/Embarcacoes/{id}";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Embarcacao findOne(Integer idEmb){
        return service.getEmbarcacaoById(idEmb);
    }

    @PostMapping("/saveEmb/{id}")
    public String save(@PathVariable("id") Integer id, Embarcacao idEmb){
       service.updateEmbarcacao(idEmb);
       return "redirect:/Embarcacoes/{id}";
    }



}
