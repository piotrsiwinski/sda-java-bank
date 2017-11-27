package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.sda.poznan.bank.backend.web.viewmodel.CreditVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

import javax.validation.Valid;

@Controller
public class CreditController {




    @PostMapping(path = "/credit", consumes = "application/json")
    public ResponseEntity getCredit(@RequestBody @Valid CreditVM viewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        CreditVM.(viewModel);

        return ResponseEntity.ok("Przelew sie udal");
    }
}
