package com.example.projeto2_web.Classes.Pagamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento createPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> getAllPagamentoes() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> getPagamentoById(int id) {
        return pagamentoRepository.findById(id);
    }

    public Pagamento updatePagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public void deletePagamento(int id) {
        pagamentoRepository.deleteById(id);
    }

}
