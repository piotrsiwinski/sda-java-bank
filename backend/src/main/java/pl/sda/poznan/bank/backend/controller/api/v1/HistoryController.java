package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {

    private HistoryRepository historyRepository;

    @Autowired
    public HistoryController(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

    @GetMapping("/{id}")
    public ModelAndView getHistory(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("historyId");
        modelAndView.addObject("historyId", historyRepository.findById(id));
        return modelAndView;
    }

    @GetMapping("/{user}")
    public ModelAndView getUserHistory(@PathVariable("user") long user) {
        ModelAndView modelAndView = new ModelAndView("userHistory");
        modelAndView.addObject("userHistory", historyRepository.findById(user));
        return modelAndView;
    }

}
