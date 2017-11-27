package pl.sda.poznan.bank.backend.controller.api.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.UserServiceImp;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    private UserServiceImp userService;

    @Autowired
    public UserController(UserServiceImp userService, HistoryRepository historyRepository) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Object> saveUser(@RequestBody UserRegistrationVM userVM) {
        userService.saveUser(userVM);
        return ResponseEntity.status(201).body(userVM);
    }

}
