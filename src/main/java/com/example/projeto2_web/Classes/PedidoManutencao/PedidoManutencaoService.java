package com.example.projeto2_web.Classes.PedidoManutencao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoManutencaoService {
    private final PedidoManutencaoRepository pedidoManutencaoRepository;

    public PedidoManutencaoService(PedidoManutencaoRepository pedidoManutencaoRepository) {
        this.pedidoManutencaoRepository = pedidoManutencaoRepository;
    }

    public PedidoManutencao createPedidoManutencao(PedidoManutencao pedidoManutencao) {
        return pedidoManutencaoRepository.save(pedidoManutencao);
    }

    public List<PedidoManutencao> getAllPedidoManutencaoes() {
        return pedidoManutencaoRepository.findAll();
    }

    public Optional<PedidoManutencao> getPedidoManutencaoById(int id) {
        return pedidoManutencaoRepository.findById(id);
    }

    public PedidoManutencao updatePedidoManutencao(PedidoManutencao pedidoManutencao) {
        return pedidoManutencaoRepository.save(pedidoManutencao);
    }

    public void deletePedidoManutencao(int id) {
        pedidoManutencaoRepository.deleteById(id);
    }

}
