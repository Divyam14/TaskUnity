package com.pheonix.TaskUnity.services;


import com.pheonix.TaskUnity.models.User;
import com.pheonix.TaskUnity.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepository userRepository;


    public List<User> getAllUsers(){
        try {
            return userRepository.findAll();
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public User addUser(User newUser){
        try {

            if(userRepository.existsByEmail(newUser.getEmail())){
                newUser.setMessage("User Already Exists");
            }else {
                userRepository.save(newUser);
                newUser.setMessage("User Added");
            }

            return newUser;


        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public User getUser(int id){
        try {
            Optional<User> oneUser = userRepository.findById(id);
            return oneUser.orElse(null);
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public User updateUser(User user){
        userRepository.save(user);

        return user;
    }

    public String deleteUser(int id){
        try{
            userRepository.deleteById(id);
            return "Deleted";
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

}
