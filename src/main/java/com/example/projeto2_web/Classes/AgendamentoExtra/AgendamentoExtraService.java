package com.example.projeto2_web.Classes.AgendamentoExtra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgendamentoExtraService {

    private final AgendamentoExtraRepository agendamentoExtraRepository;

    public AgendamentoExtraService(AgendamentoExtraRepository agendamentoExtraRepository) {
        this.agendamentoExtraRepository = agendamentoExtraRepository;
    }

    public List<AgendamentoExtra> getAllAgendamentoExtra() {
        return agendamentoExtraRepository.findAll();
    }

    public AgendamentoExtra getAgendamentoExtraById(AgendamentoExtraPK id) {
        return agendamentoExtraRepository.findById(id).orElse(null);
    }

    public AgendamentoExtra saveAgendamentoExtra(AgendamentoExtra agendamentoExtra) {
        return agendamentoExtraRepository.save(agendamentoExtra);
    }

    public void deleteAgendamentoExtra(AgendamentoExtra agendamentoExtra) {
        agendamentoExtraRepository.delete(agendamentoExtra);
    }
}
