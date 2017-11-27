package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

    public History findById(Long id){
        return historyRepository.findById(id);
    }

    public History findByUser(User user){
        return historyRepository.findByUser(user);
    }
}
