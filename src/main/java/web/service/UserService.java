package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserId(long id);

    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);
}
