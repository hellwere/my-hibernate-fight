package by.edu.lesson.controller;

import by.edu.lesson.entity.CompanyService;
import by.edu.lesson.entity.client.Client;
import by.edu.lesson.entity.client.Status;
import by.edu.lesson.entity.room.Record;
import by.edu.lesson.entity.room.Room;
import by.edu.lesson.entity.room.RoomStatus;
import by.edu.lesson.entity.room.Visitor;
import by.edu.lesson.entity.sport_center.Employee;
import by.edu.lesson.service.hibernate.CompanyServiceService;
import by.edu.lesson.service.hibernate.RoomService;
import by.edu.lesson.service.hibernate.VisitorService;
import by.edu.lesson.service.jpa.ClientService;
import by.edu.lesson.service.sport_center.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CriteriaBuilderController {

    public void callExTen() {
        EmployeeService employeeService = new EmployeeService();

        ArrayList <Employee> employees = new ArrayList<>() {{
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 12", "Ильич", "Илья", 1991,
                    LocalDate.parse("2023-11-06"), LocalDate.parse("2024-11-06"), "Начальник начальников", 2290.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 12", "Олег", "Олегов", 1994,
                    LocalDate.parse("2019-11-06"), LocalDate.parse("2024-11-06"), "ПодНачальник начальников", 1901.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 11", "Иван", "Иванов", 1997,
                    LocalDate.parse("2013-11-06"), LocalDate.parse("2024-11-06"), "Начальник начальниковых начальников", 12190.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 17", "Дима", "Димоооооооонов", 1992,
                    LocalDate.parse("2003-11-06"), LocalDate.parse("2024-11-06"), "Единственный рабочий", 1290.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 19", "Пустое", "Место", 1993,
                    LocalDate.parse("2003-11-06"), LocalDate.parse("2024-11-06"), "Униженный обиженный", 1.23));

        }};
        employeeService.addEmployees(employees);
        employeeService.findAllWithCriteria().forEach(System.out::println);

        CompanyServiceService companyServiceService = new CompanyServiceService();
        companyServiceService.addCompanyService(new CompanyService(null, "Спорт", 100.11, null));
        companyServiceService.addCompanyService(new CompanyService(null, "Спорт", 100.11, null));
        companyServiceService.findActivityWithCriteria("Спорт").forEach(System.out::println);

        RoomService roomService = new RoomService();
        Room trenajZal = new Room(null, "Тренажёрный зал", "123", 70L, RoomStatus.ACTIVE, 800.10, null);
        Room sauna = new Room(null, "Сауна", "444", 150L, RoomStatus.ACTIVE, 2690.10, null);
        List<Room> rooms = roomService.addRoom(List.of(trenajZal, sauna));
        System.out.println("!----- all-rooms: ");
        rooms.forEach(System.out::println);

        System.out.println(roomService.findPeopleLimitSumFromAllRoomsWithCriteria());

        ClientService clientService = new ClientService();
        clientService.addClient(List.of(
                new Client("Екотерина", "Котеевна", 18, "8-800-5553511", LocalDateTime.now(), Status.ACTIVE, 14.00, null),
                new Client("Дмитрий", "Сикдеевич", 30, "8-800-5553535",
                        LocalDateTime.of(2002, 1, 22, 10, 2, 30), Status.BLOCKED, 22, null),
                new Client("Олег", "Подкрадулев", 15, "8-800-5553522",
                        LocalDateTime.of(2022, 2, 2, 10, 2, 30), Status.PREMIUM, 25.00, null),
                new Client("Алексей", "Шоркан", 58, "8-800-5553512",
                        LocalDateTime.of(2023, 8, 22, 10, 2, 30), Status.ACTIVE, 11, null),
                new Client("Сергей", "Эгегеевич", 37, "8-800-5553544",
                        LocalDateTime.of(2025, 4, 12, 10, 2, 30), Status.PREMIUM, 180.00, null)
        ));
        clientService.findClientsFromRange(1, 30).forEach(System.out::println);

        VisitorService visitorService = new VisitorService();

        by.edu.lesson.entity.room.Record record = Record.builder()
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
                .age(11)
                .build();

        record.setVisits(visitor);
        record.setRooms(rooms.get(0));
        trenajZal.setVisits(Set.of(visitor));
        sauna.setVisits(Set.of(visitor));
        Visitor addedVisitor = visitorService.addVisit(visitor);
        System.out.println(addedVisitor);
        roomService.findRoomsByPeopleAgeLimitWithCriteria(50).forEach(System.out::println);

    }
}
