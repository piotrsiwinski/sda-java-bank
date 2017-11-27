package pl.sda.poznan.bank.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.exception.UserNotFoundException;
import pl.sda.poznan.bank.backend.model.BankUserPrincipal;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.UserRepository;

@Service
public class BankUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public BankUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = userRepository.findByLogin(login).orElse(null);
        return new BankUserPrincipal(user);
    }
}
