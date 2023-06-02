package com.example.projeto2_web.Classes.Agendamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
     List<Agendamento> findAgendamentosByIdutilizadorOrderByDataDesc(int id);
}