package by.edu.lesson.service.hibernate;

import by.edu.lesson.entity.client.Client;
import by.edu.lesson.entity.client.PremiumClient;
import by.edu.lesson.repository.hibernate.ClientRepository;

import java.util.List;

public class ClientService {

    private final ClientRepository repository;

    public ClientService() {
        this.repository = new ClientRepository();
    }

    public Client searchById(Long id) {
        return repository.findById(id);
    }

    public List<PremiumClient> getPremiumClients() {
        return repository.getPremiumClients();
    }
}
