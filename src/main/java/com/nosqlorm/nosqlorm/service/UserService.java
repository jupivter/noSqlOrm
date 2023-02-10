package com.nosqlorm.nosqlorm.service;

import com.nosqlorm.nosqlorm.entities.User;
import com.nosqlorm.nosqlorm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String surname){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        return userRepository.save(user);
    }

    public User getAUser(long id) throws Exception {
        if (!userRepository.existsById(id)){
            throw new Exception("User not found");
        }
        return userRepository.findById(id).get();
    }

    public User updateUser(String name, String surname, long id) throws Exception {
        User user = getAUser(id);
        user.setName(name);
        user.setSurname(surname);
        userRepository.save(user);
        return user;
    }

    public void deleteSingle(long id) throws Exception {
        if (userRepository.existsById(id))
            userRepository.deleteById(id);
        else throw new Exception("Impossible to delete user");
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }
}
