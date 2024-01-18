package task.management.service;

import java.util.List;
import java.util.Optional;

import task.management.entity.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
