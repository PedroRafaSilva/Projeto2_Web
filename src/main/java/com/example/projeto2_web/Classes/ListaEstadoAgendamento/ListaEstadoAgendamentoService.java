package com.example.projeto2_web.Classes.ListaEstadoAgendamento;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListaEstadoAgendamentoService {

    private final ListaEstadoAgendamentoRepository listaEstadoAgendamentoRepository;

    public ListaEstadoAgendamentoService(ListaEstadoAgendamentoRepository listaEstadoAgendamentoRepository) {
        this.listaEstadoAgendamentoRepository = listaEstadoAgendamentoRepository;
    }

    public List<ListaEstadoAgendamento> getAllListaEstadoAgendamento() {
        return listaEstadoAgendamentoRepository.findAll();
    }

    public ListaEstadoAgendamento getListaEstadoAgendamentoById(ListaEstadoAgendamentoPK id) {
        return listaEstadoAgendamentoRepository.findById(id).orElse(null);
    }

    public ListaEstadoAgendamento saveListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) {
        return listaEstadoAgendamentoRepository.save(listaEstadoAgendamento);
    }

    public void deleteListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) {
        listaEstadoAgendamentoRepository.delete(listaEstadoAgendamento);
    }
}
