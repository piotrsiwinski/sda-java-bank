/*TODO Napisz oddzielne klasy z adnotacja getMapping ktore beda zwracaly pojedynczego klienta a pozniej wstrzykuj je
TODO w klasy ktore dodaja historie itd*/
//TODO popracuj nad bankAccountService, zeby moc tworzyc jego instancje i wywolywac jego funkcje


package pl.sda.poznan.bank.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.service.BankAccountService;
import pl.sda.poznan.bank.backend.service.OperationHistory;
import pl.sda.poznan.bank.backend.service.UserService;


@Controller
@RequestMapping("/bank")
public class BankAccountController {

    BankAccountService bankAccountService;

    OperationHistory history;

    UserService userService;

    UserController userController;

    public BankAccountController(OperationHistory history, UserService userService, UserController userController) {
        this.history = history;
        this.userService = userService;
        this.userController = userController;
    }

    @Autowired(required = false)
    public void setBankAccountService(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping(value = "/wplata")
    public ModelAndView wplata(@ModelAttribute User user, @ModelAttribute double amount) {
        bankAccountService.payment(amount, user);
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

    @PostMapping(value = "/przelew")
    public ModelAndView przelew(@ModelAttribute User user) {
        bankAccountService.transfer(400.0, userService.findUser(user.getId()));
        System.out.println("wiadomosc test3");
        return new ModelAndView("start");
    }


}
