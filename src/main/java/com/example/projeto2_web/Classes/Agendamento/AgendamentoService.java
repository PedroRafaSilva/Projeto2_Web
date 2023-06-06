package com.example.projeto2_web.Classes.Agendamento;

import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamento;
import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamentoRepository;
import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamentoService;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public Agendamento createAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> getAllAgendamentoes() {
        return agendamentoRepository.findAll();
    }

    public Agendamento getAgendamentoById(int id) {
        if (agendamentoRepository.findById(id).isPresent()) {
            return agendamentoRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Agendamento updateAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public void deleteAgendamento(int id) {
        agendamentoRepository.deleteById(id);
    }

    public List<Agendamento> findAgendamentosByUtilizadorOrderByData(int id){
        return agendamentoRepository.findAgendamentosByIdutilizadorOrderByDataDesc(id);
    }

}
