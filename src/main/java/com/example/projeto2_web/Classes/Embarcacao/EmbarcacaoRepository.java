package com.example.projeto2_web.Classes.Embarcacao;

import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmbarcacaoRepository extends JpaRepository<Embarcacao, Integer> {
    List<Embarcacao> findEmbarcacaosByUtilizadorByIdutilizadorOrderByNome(Utilizador utilizador);
}