package by.edu.lesson.service.sport_center;

import by.edu.lesson.entity.sport_center.User;
import by.edu.lesson.repository.sport_center.UserRepository;
import by.edu.lesson.repository.sport_center.impl.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class UserService {

    private final UserRepository repository;

    public UserService() {
        this.repository = new UserRepositoryImpl();
    }

    public User addUser(User User) {
        return repository.addUser(User);
    }

    public List<User> addUsers(List<User> Users) {
        ArrayList<User> list = new ArrayList<>();
        for (User User : Users) {
            list.add(addUser(User));
        }
        return list;
    }

    public User findById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
