package by.edu.lesson.repository.sport_center;

import by.edu.lesson.entity.sport_center.User;

import java.util.List;

public interface UserRepository {
    User addUser(User user);
    User findById(Long id);
    List<User> findAll();
}
