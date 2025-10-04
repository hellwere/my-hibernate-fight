package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.room.Room;
import by.edu.lesson.entity.room.SubselectRoom;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.util.List;

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

    public List<SubselectRoom> getRoomWithMaxPeople() {
        Session unwrap = entityManager.unwrap(Session.class);
        try (Session session = unwrap.getSessionFactory().openSession()){
            return session.createQuery("select s from SubselectRoom s", SubselectRoom.class).getResultList();
        }
    }
}
