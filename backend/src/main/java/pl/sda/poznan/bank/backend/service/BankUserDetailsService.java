package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.BankUserPrincipal;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.UserRepository;

@Service
public class BankUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException(login);
        }
        return new BankUserPrincipal(user);
    }
}
