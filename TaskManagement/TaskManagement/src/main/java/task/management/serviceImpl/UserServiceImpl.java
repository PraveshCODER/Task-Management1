package task.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.management.entity.User;
import task.management.exception.UserNotFoundException;
import task.management.repository.UserRepository;
import task.management.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        // Additional logic can be added if needed
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        // Update existing user properties
        existingUser.setUsername(user.getUsername());
        existingUser.setFullName(user.getFullName());
        existingUser.setUsername(user.getUsername());

        // Additional logic can be added if needed

        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }

        userRepository.deleteById(id);
    }
}
