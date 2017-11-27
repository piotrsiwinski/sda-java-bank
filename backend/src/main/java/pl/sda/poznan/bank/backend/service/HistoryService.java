package pl.sda.poznan.bank.backend.service;

import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;

@Service
public interface HistoryService {

    History findById(Long id);

    History findByUser(User user);
}
