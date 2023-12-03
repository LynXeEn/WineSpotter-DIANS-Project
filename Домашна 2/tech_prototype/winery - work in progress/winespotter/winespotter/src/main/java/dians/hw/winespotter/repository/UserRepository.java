package dians.hw.winespotter.repository;

import dians.hw.winespotter.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public static List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("hstnvska","hs","Hristina","Stojanovska"));
    }

    public Optional<User> findByUsername(String username){
        return users.stream().filter(r->r.getUsername().equals(username)).findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username,String password){
        return users.stream().filter(r->r.getUsername().equals(username) && r.getPassword().equals(password))
                .findFirst();
    }

    public User saveOrUpdate(User user){
        users.removeIf(r->r.getUsername().equals(user.getUsername()));
        users.add(user);
        return user;
    }

    public void delete(String username){
        users.removeIf(r->r.getUsername().equals(username));
    }

}
