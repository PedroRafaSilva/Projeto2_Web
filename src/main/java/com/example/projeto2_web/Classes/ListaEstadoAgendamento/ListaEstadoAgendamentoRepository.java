package com.example.projeto2_web.Classes.ListaEstadoAgendamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaEstadoAgendamentoRepository extends JpaRepository<ListaEstadoAgendamento, ListaEstadoAgendamentoPK> {
    public List<ListaEstadoAgendamento> findListaEstadoAgendamentoByIdagendamento(int id);
}