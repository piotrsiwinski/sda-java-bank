/*TODO Napisz oddzielne klasy z adnotacja getMapping ktore beda zwracaly pojedynczego klienta a pozniej wstrzykuj je
TODO w klasy ktore dodaja historie itd*/
//TODO popracuj nad bankAccountService, zeby moc tworzyc jego instancje i wywolywac jego funkcje


package pl.sda.poznan.bank.backend.controller;

import bank.labs.model.Client;
import bank.labs.service.BankAccountService;
import bank.labs.service.ClientService;
import bank.labs.service.OperationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/bank")
public class BankAccountController {

    BankAccountService bankAccountService;

    OperationHistory history;

    ClientService clientService;

    ClientController clientController;
    public BankAccountController(OperationHistory history, ClientService clientService, ClientController clientController) {
        this.history = history;
        this.clientService = clientService;
        this.clientController = clientController;
    }

    @Autowired(required = false)
    public void setBankAccountService(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    public ModelAndView wplata(@ModelAttribute Client client, @ModelAttribute double amount) {
        bankAccountService.payment(amount,client);
        System.out.println("wiadomosc test");
        return new ModelAndView("start");
    }
//TODO popraw na posta
    @GetMapping("/wyplata")
    public ModelAndView wyplata() {
        bankAccountService.payoff(400.0);
        System.out.println("wiadomosc test2");
        return new ModelAndView("start");
    }

    @PostMapping
    public ModelAndView przelew(@ModelAttribute Client client) {
        bankAccountService.transfer(400.0, clientService.getClient(client.getId()));
        System.out.println("wiadomosc test3");
        return new ModelAndView("start");
    }


}
