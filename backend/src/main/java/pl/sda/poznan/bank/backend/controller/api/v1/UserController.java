package pl.sda.poznan.bank.backend.controller.api.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.impl.BankUserDetailsServiceImpl;
import pl.sda.poznan.bank.backend.service.impl.UserServiceImpl;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

import javax.validation.Valid;

import java.security.Principal;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    private UserServiceImpl userService;
    private BankUserDetailsServiceImpl bankUserDetailsService;

    @Autowired
    public UserController(UserServiceImpl userService, HistoryRepository historyRepository,
                          BankUserDetailsServiceImpl bankUserDetailsService) {
        this.userService = userService;
        this.bankUserDetailsService = bankUserDetailsService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRegistrationVM userVM, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Bad data");
        }
        userService.saveUser(userVM);
        return ResponseEntity.status(201).body(userVM);
    }

    @GetMapping(path = "/me")
    public ResponseEntity<Object> getUser(Principal principal) {
        String username = principal.getName();
        User user = this.bankUserDetailsService.findUserByLogin(username);
        return ResponseEntity.status(200).body(user);
    }

}
