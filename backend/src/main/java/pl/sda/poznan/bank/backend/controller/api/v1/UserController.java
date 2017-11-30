package pl.sda.poznan.bank.backend.controller.api.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.impl.UserServiceImpl;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService, HistoryRepository historyRepository) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRegistrationVM userVM, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Bad data");
        }
        userService.saveUser(userVM);
        return ResponseEntity.status(201).body(userVM);
    }


}
