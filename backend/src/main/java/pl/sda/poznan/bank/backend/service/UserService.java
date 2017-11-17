package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.UserRepository;

import java.util.List;

@Component
public class UserService {

    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(long id){
        return userRepository.findById(id);
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
