package pl.sda.poznan.bank.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.poznan.bank.backend.service.BankAcconutService;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    private BankAcconutService bankAcconutService;

    @Autowired
    public BankAccountController(BankAcconutService bankAcconutService){
        this.bankAcconutService = bankAcconutService;
    }



}
