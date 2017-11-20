package pl.sda.poznan.bank.backend.service;

import bank.labs.model.Client;
import bank.labs.model.History;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OperationHistory {

    private ArrayList<History> clientHistory;

    private Client client;

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
