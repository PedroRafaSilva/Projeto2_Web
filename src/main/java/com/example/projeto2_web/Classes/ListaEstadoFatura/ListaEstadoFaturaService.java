package com.example.projeto2_web.Classes.ListaEstadoFatura;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListaEstadoFaturaService {

    private final ListaEstadoFaturaRepository listaEstadoFaturaRepository;

    public ListaEstadoFaturaService(ListaEstadoFaturaRepository listaEstadoFaturaRepository) {
        this.listaEstadoFaturaRepository = listaEstadoFaturaRepository;
    }

    public List<ListaEstadoFatura> getAllListaEstadoFatura() {
        return listaEstadoFaturaRepository.findAll();
    }

    public ListaEstadoFatura getListaEstadoFaturaById(ListaEstadoFaturaPK id) {
        return listaEstadoFaturaRepository.findById(id).orElse(null);
    }

    public ListaEstadoFatura saveListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) {
        return listaEstadoFaturaRepository.save(listaEstadoFatura);
    }

    public void deleteListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) {
        listaEstadoFaturaRepository.delete(listaEstadoFatura);
    }
}
