package com.example.projeto2_web.Classes.Fatura;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public Fatura createFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> getAllFaturaes() {
        return faturaRepository.findAll();
    }

    public Optional<Fatura> getFaturaById(int id) {
        return faturaRepository.findById(id);
    }

    public Fatura updateFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public void deleteFatura(int id) {
        faturaRepository.deleteById(id);
    }

    public List<Fatura> findAFaturasByUtilizadorOrderByData(int id){
        List<Fatura> faturas = faturaRepository.findFaturasByIdutilizadorOrderByDatacriacaoDesc(id);
        List<Fatura> faturasDisponiveis = new ArrayList<>();
        for (Fatura fatura: faturas){
            if (fatura.getDatacriacao().toLocalDate().isBefore(LocalDate.now())){
                faturasDisponiveis.add(fatura);
            }
        }
        return faturasDisponiveis;
    }

    public Fatura FindByUtilizadorAndMonthOfNow(int id){
        List<Fatura> faturas = faturaRepository.findFaturasByIdutilizadorOrderByDatacriacaoDesc(id);
        for(Fatura fatura: faturas) {
            if(fatura.getDatacriacao().toLocalDate().getMonth().equals(LocalDate.now().getMonth())
            && fatura.getDatacriacao().toLocalDate().getYear() == LocalDate.now().getYear()){
                return fatura;
            }
        }
        return null;
    }

    public List<Fatura> getAllFaturasGenerated(int id) {
        List<Fatura> faturas = findAFaturasByUtilizadorOrderByData(id);
        List<Fatura> faturaList = new ArrayList<>();
        for(Fatura fatura: faturas) {
            if(fatura.getDatacriacao().toLocalDate().getMonth().getValue() < LocalDate.now().getMonthValue()
                    && fatura.getDatacriacao().toLocalDate().getYear() <= LocalDate.now().getYear()){
                faturaList.add(fatura);
            }
        }
        return faturaList;
    }
}
