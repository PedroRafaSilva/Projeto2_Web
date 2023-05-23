package com.example.projeto2_web.Classes.Extra;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraService {
    private final ExtraRepository extraRepository;

    public ExtraService(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    public Extra createExtra(Extra extra) {
        return extraRepository.save(extra);
    }

    public List<Extra> getAllExtraes() {
        return extraRepository.findAll();
    }

    public Optional<Extra> getExtraById(int id) {
        return extraRepository.findById(id);
    }

    public Extra updateExtra(Extra extra) {
        return extraRepository.save(extra);
    }

    public void deleteExtra(int id) {
        extraRepository.deleteById(id);
    }

}
