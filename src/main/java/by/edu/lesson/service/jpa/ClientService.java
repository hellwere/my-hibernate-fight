package by.edu.lesson.service.jpa;

import by.edu.lesson.entity.client.Client;
import by.edu.lesson.entity.client.Status;
import by.edu.lesson.repository.ClientRepository;
import by.edu.lesson.repository.jpa.ClientRepositoryImpl;

import java.util.List;

public class ClientService {

    private final ClientRepository clientRepository = new ClientRepositoryImpl();

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public void addClient(List<Client> clients) {
        for (Client client : clients) {
            this.addClient(client);
        }
    }

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public void deleteClient(Client client) {
        clientRepository.deleteClient(client);
    }

    public void changeClientStatus(Long id, Status status) {
        Client client = clientRepository.findClientById(id);
        client.setStatus(status);
        clientRepository.changeClient(client);
    }

    public List<Client> findClientsFromRange(int min, int max) {
        return clientRepository.findClientsFromRange(min, max);
    }
}
