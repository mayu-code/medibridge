package com.main.medibridge.services.ServiceInterface;
import java.util.List;

import com.main.medibridge.entities.User;



public interface UserService {
    User addUser(User user);
    User getUserById(long id);
    User getUserByEmail(String email);
    User getUserByJwt(String jwt);


    List<User> getAllPathologists();
}
