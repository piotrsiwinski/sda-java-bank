
//TODO popraw klase
package pl.sda.poznan.bank.backend.service;


import org.springframework.stereotype.Component;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;

import java.util.ArrayList;

@Component
public class OperationHistory {

    private ArrayList<History> clientHistory;

    private User user;

    public OperationHistory() {
        this.clientHistory = new ArrayList<>();
    }

    public ArrayList<History> addHistory( History history) {
        clientHistory.add(history);
        return clientHistory;
    }

    public ArrayList<History> getClientHistory() {
        return clientHistory;
    }

}
