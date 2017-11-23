package pl.sda.poznan.bank.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.poznan.bank.backend.model.Investment;
import pl.sda.poznan.bank.backend.service.InvestmentService;


@Controller
@RequestMapping("/investment")
public class InvestmentController {

    private InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService){
        this.investmentService = investmentService;
    }
    @GetMapping("/{Id}")//
    public ModelAndView getInvestment(@PathVariable ("Id") long Id){
        ModelAndView modelAndView = new ModelAndView("investment");
        modelAndView.addObject("investment", investmentService.findInvestment(Id));
        return modelAndView;
    }
    @GetMapping
    public ModelAndView getAllInvestments(){
        ModelAndView modelAndView = new ModelAndView("allInvestments");
        modelAndView.addObject("investment", investmentService.findAllInvestments());
        return modelAndView;
    }
    @PostMapping
    public String addInvestment(@ModelAttribute Investment investment){
        investmentService.saveInvestment(investment);
        return "redirect:/allInvestments";
    }
    @GetMapping(path = "/{id}/remove")
    public String removeInvestment(@PathVariable("id") long id){
        investmentService.removeInvestment(id);
        return "redirect:/allInvestments";
    }

  @PostMapping
    public String updateInvestment(@ModelAttribute long id, Investment investment){
        investmentService.updateInvestment(id, investment);
        return "redirect:/allInvestments";
    }
}
