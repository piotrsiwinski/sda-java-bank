package pl.sda.poznan.bank.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.poznan.bank.backend.model.Investment;
import pl.sda.poznan.bank.backend.service.InvestmentService;
import java.util.List;


@RestController
@RequestMapping("/investment")
public class InvestmentController {

    private InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/{Id}")//
    public ResponseEntity<Investment> getInvestment(@PathVariable("Id") long id) {
        Investment investment = (investmentService.findInvestment(id));
        return new ResponseEntity<>(investment, HttpStatus.OK);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Investment>> getAllInvestments() {
        List<Investment> allInvestments = investmentService.findAllInvestments();
        return new ResponseEntity<>(allInvestments, HttpStatus.OK);
    }

    @PostMapping("/addInvestment")
    public ResponseEntity<List<Investment>> addInvestment (@ModelAttribute Investment investment) {
        investmentService.saveInvestment(investment);
        List<Investment> allInvestments = investmentService.findAllInvestments();
        return new ResponseEntity<>(allInvestments, HttpStatus.OK);
    }

    @GetMapping("/{id}/remove")
    public ResponseEntity<List<Investment>> removeInvestment(@PathVariable("id") long id) {
        investmentService.removeInvestment(id);
        List<Investment> allInvestments = investmentService.findAllInvestments();
        return new ResponseEntity<>(allInvestments, HttpStatus.OK);
    }

    @PostMapping("/updateInvestment")
    public ResponseEntity<List<Investment>> updateInvestment(@ModelAttribute long id, Investment investment) {
        investmentService.updateInvestment(id, investment);
        List<Investment> allInvestments = investmentService.findAllInvestments();
        return new ResponseEntity<>(allInvestments, HttpStatus.OK);
    }
}
