package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.CompanyService;
import by.edu.lesson.entity.room.Room;
import by.edu.lesson.entity.room.SubselectRoom;
import by.edu.lesson.entity.room.Visitor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.util.List;

public class RoomRepository {

    private final EntityManager entityManager;
    private final HibernateConnection hibernateConnection;

    public RoomRepository() {
        this.entityManager = new HibernateConnection().getEntityManager();
        this.hibernateConnection = new HibernateConnection();
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

    public Room findById(Long id) {
        return entityManager.find(Room.class, id);
    }

    public Long findPeopleLimitSumFromAllRoomsWithCriteria() {
        try (EntityManager entityManager = hibernateConnection.getEntityManager()) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> query = cb.createQuery(Long.class);
            Root<Room> root = query.from(Room.class);

            query.select(cb.sum(root.get("peopleLimit")));

            return entityManager.createQuery(query).getSingleResult();
        }
    }

    public List<Room> findRoomsByPeopleAgeLimitWithCriteria(int age) {
        try (EntityManager entityManager = hibernateConnection.getEntityManager()) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Room> query = cb.createQuery(Room.class);
            Root<Room> root = query.from(Room.class);
            Join<Room, Visitor> join = root.join("visits");

            query.select(root).where(cb.gt(join.get("age"), age));

            return entityManager.createQuery(query).getResultList();
        }
    }
}
