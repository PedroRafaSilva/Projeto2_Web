package com.example.projeto2_web.Classes.Comprimento;

import com.example.projeto2_web.Classes.Comprimento.Comprimento;
import com.example.projeto2_web.Classes.Comprimento.ComprimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprimentoService {
    private final ComprimentoRepository comprimentoRepository;

    public ComprimentoService(ComprimentoRepository comprimentoRepository) {
        this.comprimentoRepository = comprimentoRepository;
    }

    public Comprimento createComprimento(Comprimento comprimento) {
        return comprimentoRepository.save(comprimento);
    }

    public List<Comprimento> getAllComprimentoes() {
        return comprimentoRepository.findAll();
    }

    public Optional<Comprimento> getComprimentoById(int id) {
        return comprimentoRepository.findById(id);
    }

    public Comprimento updateComprimento(Comprimento comprimento) {
        return comprimentoRepository.save(comprimento);
    }

    public void deleteComprimento(int id) {
        comprimentoRepository.deleteById(id);
    }

}
