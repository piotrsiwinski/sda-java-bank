package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.poznan.bank.backend.service.impl.CreditServiceImpl;
import pl.sda.poznan.bank.backend.web.viewmodel.CreditVM;

import javax.validation.Valid;

@Controller
public class CreditController {

    private CreditServiceImpl creditService;

    @Autowired
    public CreditController(CreditServiceImpl creditService) {
        this.creditService = creditService;
    }
    //TODO sprawdz czy dobrze jest pobrany id
    @PostMapping(path = "/credit", consumes = "application/json")
    public ResponseEntity getCredit(@RequestBody @Valid CreditVM viewModel, BindingResult bindingResult, @RequestParam("id") long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        creditService.getCredit(viewModel, id);

        return ResponseEntity.ok("Udzielono kredytu");
    }
}
