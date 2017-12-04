package pl.sda.poznan.bank.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.poznan.bank.backend.web.viewmodel.DepositVM;

@RestController
@RequestMapping(path = "/api/v1")
public class DepositController {
    @PostMapping(path = "/deposit")
    public ResponseEntity<?> addDeposit(@RequestBody DepositVM vm) {
        return ResponseEntity.ok().build();
    }
}
