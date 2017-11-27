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
import pl.sda.poznan.bank.backend.service.HistoryService;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {

    private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getHistoryById(@PathVariable("id") long id) {
        History historyById = historyService.findById(id);
        return ResponseEntity.status(201).body(historyById);
    }

    @GetMapping("/{user}")
    public ResponseEntity<Object> getHistoryByUser(@PathVariable("user") User user) {
        History historyByUser = historyService.findByUser(user);
        return ResponseEntity.status(201).body(historyByUser);
    }

}
