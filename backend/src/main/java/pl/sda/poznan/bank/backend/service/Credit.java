package pl.sda.poznan.bank.backend.service;

import bank.labs.model.Client;

public class Credit {


    public Double credit (Double amount, Client client) {
        if (client.getAccountType().equals("VIP")) {
            if (amount != null && amount > 0) {
                Double saldo = client.getSaldo();
                saldo += amount;
                System.out.println("Dokonano pozyczki na kwote: " + amount + ". Saldo: " + saldo);
            }
        }
        return client.getSaldo();
    }
}

