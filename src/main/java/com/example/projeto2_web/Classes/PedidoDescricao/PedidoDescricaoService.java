package com.example.projeto2_web.Classes.PedidoDescricao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoDescricaoService {
    private final PedidoDescricaoRepository pedidoDescricaoRepository;

    public PedidoDescricaoService(PedidoDescricaoRepository pedidoDescricaoRepository) {
        this.pedidoDescricaoRepository = pedidoDescricaoRepository;
    }

    public PedidoDescricao createPedidoDescricao(PedidoDescricao pedidoDescricao) {
        return pedidoDescricaoRepository.save(pedidoDescricao);
    }

    public List<PedidoDescricao> getAllPedidoDescricaoes() {
        return pedidoDescricaoRepository.findAll();
    }

    public Optional<PedidoDescricao> getPedidoDescricaoById(String id) {
        return pedidoDescricaoRepository.findById(id);
    }

    public PedidoDescricao updatePedidoDescricao(PedidoDescricao pedidoDescricao) {
        return pedidoDescricaoRepository.save(pedidoDescricao);
    }

    public void deletePedidoDescricao(String id) {
        pedidoDescricaoRepository.deleteById(id);
    }

}
