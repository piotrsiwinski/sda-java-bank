package pl.sda.poznan.bank.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.UserService;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private HistoryRepository historyRepository;

    @Autowired
    public UserController(UserService userService, HistoryRepository historyRepository) {
        this.userService = userService;
        this.historyRepository = historyRepository;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Object> saveUser(@RequestBody UserRegistrationVM userVM) {
        userService.saveUser(userVM);
        return ResponseEntity.status(201).body(userVM);
    }


}
