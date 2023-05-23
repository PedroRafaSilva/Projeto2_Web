package com.example.projeto2_web.Classes.EstadoAgendamento;

import com.example.projeto2_web.Classes.EstadoAgendamento.EstadoAgendamento;
import com.example.projeto2_web.Classes.EstadoAgendamento.EstadoAgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoAgendamentoService {
    private final EstadoAgendamentoRepository estadoAgendamentoRepository;

    public EstadoAgendamentoService(EstadoAgendamentoRepository estadoAgendamentoRepository) {
        this.estadoAgendamentoRepository = estadoAgendamentoRepository;
    }

    public EstadoAgendamento createEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
        return estadoAgendamentoRepository.save(estadoAgendamento);
    }

    public List<EstadoAgendamento> getAllEstadoAgendamentoes() {
        return estadoAgendamentoRepository.findAll();
    }

    public Optional<EstadoAgendamento> getEstadoAgendamentoById(int id) {
        return estadoAgendamentoRepository.findById(id);
    }

    public EstadoAgendamento updateEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
        return estadoAgendamentoRepository.save(estadoAgendamento);
    }

    public void deleteEstadoAgendamento(int id) {
        estadoAgendamentoRepository.deleteById(id);
    }

}
