package by.edu.lesson.service.hibernate;

import by.edu.lesson.entity.room.Visitor;
import by.edu.lesson.repository.hibernate.VisitorRepository;

import java.util.ArrayList;
import java.util.List;

public class VisitorService {

    private final VisitorRepository repository;

    public VisitorService() {
        this.repository = new VisitorRepository();
    }

    public List<Visitor> addVisitors(List<Visitor> visitors) {
        ArrayList<Visitor> lst = new ArrayList<>();
        for (Visitor visitor : visitors) {
            addVisit(visitor);
        }
        return lst;
    }

    public Visitor addVisit(Visitor visitor) {
        return repository.addVisit(visitor);
    }
}
