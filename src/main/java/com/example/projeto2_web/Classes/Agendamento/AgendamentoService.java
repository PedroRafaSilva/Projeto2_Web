package com.example.projeto2_web.Classes.Agendamento;

import org.springframework.stereotype.Service;

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

    public Optional<Agendamento> getAgendamentoById(int id) {
        return agendamentoRepository.findById(id);
    }

    public Agendamento updateAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public void deleteAgendamento(int id) {
        agendamentoRepository.deleteById(id);
    }

    public List<Agendamento> findAgendamentosByUtilizador(int id){
        return agendamentoRepository.findAgendamentosByIdutilizador(id);
    }

}
