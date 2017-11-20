package pl.sda.poznan.bank.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.UserService;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private UserService userService;
    private HistoryRepository historyRepository;

    @Autowired
    public ClientController(UserService userService, HistoryRepository historyRepository) {
        this.userService = userService;
        this.historyRepository = historyRepository;
    }

    @GetMapping("{userId}")
    public ModelAndView getClientHistory(@PathVariable("userId") int userId){
        ModelAndView modelAndView = new ModelAndView("history");
        modelAndView.addObject("userId", userService.userHistory(userId));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAllClients(){
        ModelAndView modelAndView = new ModelAndView("allClients");
        modelAndView.addObject("clients", userService.findAllUsers());
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView getClient(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("client", userService.findUser(id));
        return modelAndView;
    }
    @PostMapping
    public String saveClient(@ModelAttribute User user){
        userService.saveUser(user);
        return  "redirect:/clients ";
    }
}
