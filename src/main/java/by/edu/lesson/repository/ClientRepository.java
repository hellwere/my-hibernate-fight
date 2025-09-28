package by.edu.lesson.repository;

import by.edu.lesson.entity.Client;

import java.util.List;

public interface ClientRepository {
    void addClient(Client client);
    List<Client> getAll();
    void deleteClient(Client client);
    Client findClientById(long id);
    void changeClient(Client client);
}
