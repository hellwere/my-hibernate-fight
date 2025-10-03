package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.Room;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class RoomRepository {

    private final EntityManager entityManager;

    public RoomRepository() {
        this.entityManager = new HibernateConnection().getEntityManager();
    }

    public Room addRoom(Room room) {
        Session unwrap = entityManager.unwrap(Session.class);
        try(Session session = unwrap.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(room);
            session.getTransaction().commit();
        }
        return room;
    }

    public Room addRoomWithNewIndfNumber(Room room, String indifNumber) {
        Session unwrap = entityManager.unwrap(Session.class);
        try(Session session = unwrap.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.detach(room);
            room.setId(null);
            room.setIdentificationNumber(indifNumber);
            session.merge(room);
            session.getTransaction().commit();
        }
        return room;
    }

    public Room changeAmountPerHour(Room room, Double amount) {
        Session unwrap = entityManager.unwrap(Session.class);
        try(Session session = unwrap.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.detach(room);
            room.setAmountPerHour(amount);
            session.merge(room);
            session.getTransaction().commit();
        }
        return room;
    }
}
