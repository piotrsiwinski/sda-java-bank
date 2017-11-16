package pl.sda.poznan.bank.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(path = {"", "/", "/home", "/index"})
    public String index() {
        return "Hello Spring";
    }
}
