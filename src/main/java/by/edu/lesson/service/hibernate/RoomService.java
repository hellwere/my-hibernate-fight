package by.edu.lesson.service.hibernate;

import by.edu.lesson.entity.room.Room;
import by.edu.lesson.entity.room.SubselectRoom;
import by.edu.lesson.repository.hibernate.RoomRepository;

import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private final RoomRepository repository;

    public RoomService() {
        this.repository = new RoomRepository();
    }

    public List<Room> addRoom(List<Room> rooms) {
        ArrayList<Room> lst = new ArrayList<>();
        for (Room room : rooms) {
            lst.add(addRoom(room));
        }
        return lst;
    }

    public Room addRoom(Room room) {
        return repository.addRoom(room);
    }

    public Room addRoomWithNewIndfNumber(Room room, String indifNumber) {
        return repository.addRoomWithNewIndfNumber(room, indifNumber);
    }

    public Room changeAmountPerHour(Room room, Double amount) {
        return repository.changeAmountPerHour(room, amount);
    }

    public List<SubselectRoom> getRoomWithMaxPeople() {
        return repository.getRoomWithMaxPeople();
    }
}
