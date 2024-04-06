package ru.gb_spring.homeworkspring_02.service;

import ru.gb_spring.homeworkspring_02.model.User;
import ru.gb_spring.homeworkspring_02.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User getUserByID(int id) {
        return userRepository.getById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}
