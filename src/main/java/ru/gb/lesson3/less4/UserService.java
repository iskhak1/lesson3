package ru.gb.lesson3.less4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        userRepository.save(new User(null,"Ivan","fg@gmail.com"));
        userRepository.save(new User(null,"John","asf@icloud.com"));
        userRepository.save(new User(null,"Kate","asdf@yandex.ru"));

        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id);
    }


}
