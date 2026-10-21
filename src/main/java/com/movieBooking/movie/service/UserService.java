package com.movieBooking.movie.service;

import com.movieBooking.movie.entity.User;
import com.movieBooking.movie.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //get all the users
    public List<User> getAll(){
        return userRepository.findAll();
    }
    //getUser by id
    public User getUserById(Long id){
        return userRepository.findById(id)
    }
    //create new users
    public User createUser(User user){
        return userRepository.save(user);
    }
}
