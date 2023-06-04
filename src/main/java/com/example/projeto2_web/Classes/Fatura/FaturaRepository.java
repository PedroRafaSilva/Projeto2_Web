package com.example.projeto2_web.Classes.Fatura;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaturaRepository extends JpaRepository<Fatura, Integer> {
    List<Fatura> findFaturasByIdutilizadorOrderByDatacriacaoDesc(int id);
}