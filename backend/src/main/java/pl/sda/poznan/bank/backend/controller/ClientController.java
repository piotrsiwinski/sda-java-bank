package pl.sda.poznan.bank.backend.controller;

import bank.labs.model.Client;
import bank.labs.repository.HistoryRepository;
import bank.labs.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;
    private HistoryRepository historyRepository;

    @Autowired
    public ClientController(ClientService clientService, HistoryRepository historyRepository) {
        this.clientService = clientService;
        this.historyRepository = historyRepository;
    }

    @GetMapping("{clientId}")
    public ModelAndView getClientHistory(@PathVariable("clientId") int clientId){
        ModelAndView modelAndView = new ModelAndView("history");
        modelAndView.addObject("clientId", clientService.clientHistory(clientId));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAllClients(){
        ModelAndView modelAndView = new ModelAndView("allClients");
        modelAndView.addObject("clients",clientService.getAllClients());
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView getClient(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("client", clientService.getClient(id));
        return modelAndView;
    }
    @PostMapping
    public String saveClient(@ModelAttribute Client client){
        clientService.saveClient(client);
        return  "redirect:/clients ";
    }
}
