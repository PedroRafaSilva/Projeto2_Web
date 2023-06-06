package com.example.projeto2_web.Controllers.Agendamentos;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.Agendamento.AgendamentoService;
import com.example.projeto2_web.Classes.AgendamentoExtra.AgendamentoExtra;
import com.example.projeto2_web.Classes.AgendamentoExtra.AgendamentoExtraPK;
import com.example.projeto2_web.Classes.AgendamentoExtra.AgendamentoExtraService;
import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.Embarcacao.EmbarcacaoService;
import com.example.projeto2_web.Classes.Extra.ExtraService;
import com.example.projeto2_web.Classes.Fatura.FaturaService;
import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamento;
import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamentoService;
import com.example.projeto2_web.Classes.Utilizador.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;


@Controller
public class AgendamentosController {
    @Autowired private AgendamentoService service;
    @Autowired private ListaEstadoAgendamentoService listaEstadoAgendamentoService;
    @Autowired private EmbarcacaoService embarcacaoService;
    @Autowired private FaturaService faturaService;
    @Autowired private UtilizadorService utilizadorService;
    @Autowired private ExtraService extraService;
    @Autowired private AgendamentoExtraService agendamentoExtraService;

    @GetMapping("/Agendamentos/{id}")
    public String showCalendar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("agendamentos", service.findAgendamentosByUtilizadorOrderByData(id));
        model.addAttribute("embarcacaos", embarcacaoService.findEmbarcacaosByUtilizadorByIdutilizadorOrderByNome(utilizadorService.getUtilizadorById(id)));
        model.addAttribute("id", id);
        model.addAttribute("extras", extraService.getAllExtraes());
        model.addAttribute("agendamento", new Agendamento());
        model.addAttribute("agendExtra", new AgendamentoExtra());
        return "/Agendamentos/Agendamentos";
    }

    @PostMapping("/saveAgend/{id}/{idAgend}")
    public String save(@PathVariable("id") Integer id, @PathVariable("idAgend") Integer idAgend, Agendamento agendamento, @RequestParam("horainicio") String horaInicioValue, @RequestParam("horafim") String horaFimValue) {
        CreateAgend(agendamento, id, horaInicioValue, horaFimValue);
        return "redirect:/Agendamentos/{id}";
    }

    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable("id") Integer id, Integer idAgen) {
        ListaEstadoAgendamento listaEstadoAgendamento = new ListaEstadoAgendamento();
        listaEstadoAgendamento.setIdagendamento(idAgen);
        listaEstadoAgendamento.setIdestado(1);
        listaEstadoAgendamento.setData(LocalDateTime.now());
        listaEstadoAgendamentoService.saveListaEstadoAgendamento(listaEstadoAgendamento);
        return "redirect:/Agendamentos/{id}";
    }

    @PostMapping("/editAgend/{id}/{idAgend}")
    public String edit(@PathVariable("id") Integer id, @PathVariable("idAgend") Integer idAgend, Agendamento agendamento, @RequestParam("horaInicio") String horaInicioValue, @RequestParam("horaFim") String horaFimValue){
        agendamento.setIdagendamento(idAgend);
        CreateAgend(agendamento, id, horaInicioValue, horaFimValue);
        return "redirect:/Agendamentos/{id}";
    }

    @PostMapping("/saveExtra/{id}/{idAgend}")
    public String saveExtra (@PathVariable("id") Integer id, @PathVariable("idAgend") Integer idAgend, AgendamentoExtra agendamentoExtra){
        agendamentoExtra.setIdagendamento(idAgend);
        agendamentoExtraService.saveAgendamentoExtra(agendamentoExtra);
        service.getAgendamentoById(idAgend).setValorextras(service.getAgendamentoById(idAgend).getValorextras() + agendamentoExtra.getValorextra());
        service.updateAgendamento(service.getAgendamentoById(idAgend));
        return "redirect:/Agendamentos/{id}";
    }

    @GetMapping("/deleteExtra/{idExtra}/{id}")
    public String deleteExtra(@PathVariable("id") Integer id, Integer idAgen, @PathVariable("idExtra") Integer idExtra) {
        AgendamentoExtraPK agendamentoExtraPK = new AgendamentoExtraPK();
        agendamentoExtraPK.setIdagendamento(idAgen);
        agendamentoExtraPK.setIdextra(idExtra);
        Agendamento agendamento = service.getAgendamentoById(idAgen);
        agendamento.setValorextras(agendamento.getValorextras() - agendamentoExtraService.getAgendamentoExtraById(agendamentoExtraPK).getValorextra());
        agendamentoExtraService.deleteAgendamentoExtra(agendamentoExtraService.getAgendamentoExtraById(agendamentoExtraPK));
        return "redirect:/Agendamentos/{id}";
    }

    public void CreateEstado(Agendamento agendamento){
        ListaEstadoAgendamento listaEstadoAgendamento = new ListaEstadoAgendamento();
        listaEstadoAgendamento.setData(LocalDateTime.now());
        listaEstadoAgendamento.setIdagendamento(agendamento.getIdagendamento());
        listaEstadoAgendamento.setIdestado(2);
        listaEstadoAgendamentoService.saveListaEstadoAgendamento(listaEstadoAgendamento);
    }

    public void CreateAgend(Agendamento agendamento, int id, String horaInicioValue, String horaFimValue){
        agendamento.setIdfatura(faturaService.FindByUtilizadorAndMonthOfNow(id).getIdfatura());
        agendamento.setHorainicio(Time.valueOf(horaInicioValue));
        agendamento.setHorafim(Time.valueOf(horaFimValue));
        agendamento.setIdutilizador(id);
        agendamento.setValorextras(0f);
        service.updateAgendamento(agendamento);
        CreateEstado(agendamento);
    }

}
