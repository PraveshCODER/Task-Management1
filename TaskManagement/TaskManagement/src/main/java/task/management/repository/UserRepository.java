package task.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
