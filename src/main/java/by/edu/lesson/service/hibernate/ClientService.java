package by.edu.lesson.service.hibernate;

import by.edu.lesson.entity.Client;
import by.edu.lesson.repository.hibernate.ClientRepository;

public class ClientService {

    private final ClientRepository repository;

    public ClientService() {
        this.repository = new ClientRepository();
    }

    public Client searchById(Long id) {
        return repository.findById(id);
    }
}
