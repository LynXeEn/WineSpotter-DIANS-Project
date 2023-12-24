package dians.hw.winespotter.service;

import dians.hw.winespotter.model.User;

public interface AuthenticationService {

    User login(String username, String password);
    User register(String username,String password,String repeatPassword,String name,String surname);

}
