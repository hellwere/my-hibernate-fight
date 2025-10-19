package by.edu.lesson.repository;

import by.edu.lesson.entity.client.Client;

import java.util.List;

public interface ClientRepository {
    void addClient(Client client);
    List<Client> getAll();
    void deleteClient(Client client);
    Client findClientById(long id);
    void changeClient(Client client);
    List<Client> findClientsFromRange(int min, int max);
}
