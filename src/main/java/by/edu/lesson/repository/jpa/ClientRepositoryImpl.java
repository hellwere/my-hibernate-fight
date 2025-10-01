package by.edu.lesson.repository.jpa;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.Client;
import by.edu.lesson.repository.ClientRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {

    HibernateConnection hibernateConnection = new HibernateConnection();

    @Override
    public void addClient(Client client) {
        EntityManager entityManager = hibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> getAll() {
        EntityManager entityManager = hibernateConnection.getEntityManager();
        List<Client> list = (List<Client>) entityManager.createQuery("SELECT c FROM Client c").getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public void deleteClient(Client client) {
        EntityManager entityManager = hibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        Client foundClient = entityManager.find(Client.class, client.getId());
        entityManager.remove(foundClient);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Client findClientById(long id) {
        EntityManager entityManager = hibernateConnection.getEntityManager();
        Client client = entityManager.find(Client.class, id);
        entityManager.close();
        return client;
    }

    @Override
    public void changeClient(Client client) {
        EntityManager entityManager = hibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
