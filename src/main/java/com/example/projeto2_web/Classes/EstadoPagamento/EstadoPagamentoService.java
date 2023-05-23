package com.example.projeto2_web.Classes.EstadoPagamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPagamentoService {
    private final EstadoPagamentoRepository estadoPagamentoRepository;

    public EstadoPagamentoService(EstadoPagamentoRepository estadoPagamentoRepository) {
        this.estadoPagamentoRepository = estadoPagamentoRepository;
    }

    public EstadoPagamento createEstadoPagamento(EstadoPagamento estadoPagamento) {
        return estadoPagamentoRepository.save(estadoPagamento);
    }

    public List<EstadoPagamento> getAllEstadoPagamentoes() {
        return estadoPagamentoRepository.findAll();
    }

    public Optional<EstadoPagamento> getEstadoPagamentoById(int id) {
        return estadoPagamentoRepository.findById(id);
    }

    public EstadoPagamento updateEstadoPagamento(EstadoPagamento estadoPagamento) {
        return estadoPagamentoRepository.save(estadoPagamento);
    }

    public void deleteEstadoPagamento(int id) {
        estadoPagamentoRepository.deleteById(id);
    }

}
