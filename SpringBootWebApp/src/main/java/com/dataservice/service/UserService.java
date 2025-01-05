package com.dataservice.service;

import com.dataservice.repository.UserRepository;
import com.dataservice.dao.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserInput saveUserInput(UserInput userInput){
        return userRepository.save(userInput);
    }

    public Iterable<UserInput> getUserInputs(){
        return userRepository.findAll();
    }
}
