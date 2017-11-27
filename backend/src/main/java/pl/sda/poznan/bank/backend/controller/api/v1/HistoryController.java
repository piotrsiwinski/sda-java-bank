package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {

    private HistoryRepository historyRepository;

    @Autowired
    public HistoryController(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getHistoryById(@PathVariable("id") long id) {
        History historyById = historyRepository.findById(id);
        return ResponseEntity.status(201).body(historyById);
    }

    @GetMapping("/{user}")
    public ResponseEntity<Object> getHistoryByUser(@PathVariable("user") User user) {
        History historyByUser = historyRepository.findByUser(user);
        return ResponseEntity.status(201).body(historyByUser);
    }

}
