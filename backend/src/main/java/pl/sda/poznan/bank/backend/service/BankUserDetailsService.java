package pl.sda.poznan.bank.backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.sda.poznan.bank.backend.model.User;

public interface BankUserDetailsService extends UserDetailsService {

    User findUserByLogin(String login);

}
