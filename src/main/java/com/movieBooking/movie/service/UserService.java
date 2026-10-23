package com.movieBooking.movie.service;

import com.movieBooking.movie.entity.User;
import com.movieBooking.movie.exception.UserNotFound;
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
                .orElseThrow(()-> new UserNotFound("User Not Found"));
    }
    //get user by its name
    public List<User> getAllUserByName(String name){
        return userRepository.findUserByName(name);
    }
    //create new users
    public User createUser(User user){
        return userRepository.save(user);
    }
    //update the user
    public User updateUser(Long id, User updatedUser){
        User existingUser = userRepository.findById(id).orElseThrow(()-> new UserNotFound("User not found"));
        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());

        return userRepository.save(existingUser);
    }

    //Delete The User
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
