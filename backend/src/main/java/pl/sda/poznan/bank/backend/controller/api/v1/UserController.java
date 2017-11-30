package pl.sda.poznan.bank.backend.controller.api.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.impl.UserServiceImpl;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService, HistoryRepository historyRepository) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Object> saveUser(@RequestBody UserRegistrationVM userVM) {
        userService.saveUser(userVM);
        return ResponseEntity.status(201).body(userVM);
    }

    @CrossOrigin
    @GetMapping(path = "/me")
    public ResponseEntity<Object> getUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails){
                String username = ((UserDetails) principal).getUsername();
                User userByUsername = userService.findUserByUsername(username);
                return ResponseEntity.status(201).body(userByUsername);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
