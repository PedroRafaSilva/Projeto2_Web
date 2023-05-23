package com.example.projeto2_web.Classes.ListaEmbarcacao;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListaEmbarcacaoService {

    private final ListaEmbarcacaoRepository listaEmbarcacaoRepository;

    public ListaEmbarcacaoService(ListaEmbarcacaoRepository listaEmbarcacaoRepository) {
        this.listaEmbarcacaoRepository = listaEmbarcacaoRepository;
    }

    public List<ListaEmbarcacao> getAllListaEmbarcacao() {
        return listaEmbarcacaoRepository.findAll();
    }

    public ListaEmbarcacao getListaEmbarcacaoById(ListaEmbarcacaoPK id) {
        return listaEmbarcacaoRepository.findById(id).orElse(null);
    }

    public ListaEmbarcacao saveListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) {
        return listaEmbarcacaoRepository.save(listaEmbarcacao);
    }

    public void deleteListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) {
        listaEmbarcacaoRepository.delete(listaEmbarcacao);
    }
}

