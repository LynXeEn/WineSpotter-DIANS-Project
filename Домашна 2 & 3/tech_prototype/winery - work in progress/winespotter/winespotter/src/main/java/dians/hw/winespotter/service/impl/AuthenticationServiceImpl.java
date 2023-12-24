package dians.hw.winespotter.service.impl;

import dians.hw.winespotter.model.User;
import dians.hw.winespotter.model.exceptions.InvalidArgumentException;
import dians.hw.winespotter.model.exceptions.InvalidUserCredentialsException;
import dians.hw.winespotter.model.exceptions.PasswordsDoNotMatchException;
import dians.hw.winespotter.repository.UserRepository;
import dians.hw.winespotter.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username,password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if(username == null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        User user = new User(username,password,name,surname);
        return userRepository.saveOrUpdate(user);
    }
}
