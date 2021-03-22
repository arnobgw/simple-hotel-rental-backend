package simple.rental.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.rental.api.entities.User;
import simple.rental.api.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(String userName) {
        return userRepository.findById(userName);
    }

    public User findByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    public void register(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
