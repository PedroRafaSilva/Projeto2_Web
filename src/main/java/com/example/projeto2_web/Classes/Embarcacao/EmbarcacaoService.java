package com.example.projeto2_web.Classes.Embarcacao;

import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.Embarcacao.EmbarcacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmbarcacaoService {
    private final EmbarcacaoRepository embarcacaoRepository;

    public EmbarcacaoService(EmbarcacaoRepository embarcacaoRepository) {
        this.embarcacaoRepository = embarcacaoRepository;
    }

    public Embarcacao createEmbarcacao(Embarcacao embarcacao) {
        return embarcacaoRepository.save(embarcacao);
    }

    public List<Embarcacao> getAllEmbarcacaoes() {
        return embarcacaoRepository.findAll();
    }

    public Optional<Embarcacao> getEmbarcacaoById(int id) {
        return embarcacaoRepository.findById(id);
    }

    public Embarcacao updateEmbarcacao(Embarcacao embarcacao) {
        return embarcacaoRepository.save(embarcacao);
    }

    public void deleteEmbarcacao(int id) {
        embarcacaoRepository.deleteById(id);
    }

}
