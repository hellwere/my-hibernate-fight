package by.edu.lesson.controller;

import by.edu.lesson.entity.CompanyService;
import by.edu.lesson.entity.room.Record;
import by.edu.lesson.entity.room.Room;
import by.edu.lesson.entity.room.RoomStatus;
import by.edu.lesson.entity.room.Visitor;
import by.edu.lesson.service.hibernate.CompanyServiceService;
import by.edu.lesson.service.hibernate.RoomService;
import by.edu.lesson.service.hibernate.VisitorService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class RoomController {
    public void callExerciseNine() {

        RoomService roomService = new RoomService();

        Room trenajZal = new Room(null, "Тренажёрный зал", "123", 70L, RoomStatus.ACTIVE, 800.10);
        Room sauna = new Room(null, "Сауна", "444", 150L, RoomStatus.ACTIVE, 2690.10);
        List<Room> rooms = roomService.addRoom(List.of(trenajZal, sauna));
        System.out.println("!----- all-rooms: " + rooms);


        CompanyServiceService companyServiceService = new CompanyServiceService();
        CompanyService trener = new CompanyService(null, "Тренер", "25.24", Set.of(trenajZal));
        CompanyService banshik = new CompanyService(null, "Парильщик", "25.24", Set.of(sauna));

        List<CompanyService> companyService = companyServiceService.addCompanyService(List.of(trener, banshik));
        System.out.println("!----- Company services: " + companyService);

        VisitorService visitorService = new VisitorService();

        Record record = Record.builder()
                .id(null)
                .clientId("ID_CLIENT11")
                .roomId(rooms.get(0).getId())
                .date(LocalDate.now())
                .time(LocalTime.now())
                .build();

        Visitor visitor = Visitor.builder()
                .id(null)
                .visitDate(LocalDate.now())
                .spentAmount(new BigDecimal(1000))
                .rooms(Set.of(rooms.get(0)))
                .records(Set.of(record))
                .build();

        record.setVisits(visitor);
        record.setRooms(rooms.get(0));


        Visitor addedVisitor = visitorService.addVisit(visitor);

        System.out.println("visitor --> " + addedVisitor);
    }
}
