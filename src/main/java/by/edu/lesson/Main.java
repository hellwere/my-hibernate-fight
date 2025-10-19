package by.edu.lesson;

import by.edu.lesson.controller.RoomController;

public class Main {

    public static void main(String[] args) {
        new RoomController().callExerciseNine();
    }

    /*public static void callExerciseSeven() {
        ClientService clientService = new ClientService();
        clientService.addClient(Arrays.asList(
                new Client("Екотерина", "Котеевна", 18, "8-800-5553511", LocalDateTime.now(), Status.ACTIVE, 14.00,
                        new Address("MyCityNumber1", "MyStreetNumber2", 221, "222332")),
                new Client("Дмитрий", "Сикдеевич", 30, "8-800-5553535",
                        LocalDateTime.of(2002, 1, 22, 10, 2, 30), Status.BLOCKED, 22,
                        new Address("MyCityNumber11", "MyStreetNumber22", 222, "2223321")),
                new Client("Олег", "Подкрадулев", 15, "8-800-5553522",
                        LocalDateTime.of(2022, 2, 2, 10, 2, 30), Status.PREMIUM, 25.00,
                        new Address("MyCityNumber111", "MyStreetNumber222", 223, "2223322")),
                new Client("Алексей", "Шоркан", 58, "8-800-5553512",
                        LocalDateTime.of(2023, 8, 22, 10, 2, 30), Status.ACTIVE, 11,
                        new Address("MyCityNumber1111", "MyStreetNumber2222", 224, "2223323")),
                new Client("Сергей", "Эгегеевич", 37, "8-800-5553544",
                        LocalDateTime.of(2025, 4, 12, 10, 2, 30), Status.PREMIUM, 180.00,
                        new Address("MyCityNumber111111", "MyStreetNumber222222", 225, "2223324"))
        ));

        List<Client> clients = clientService.getAll();
        System.out.println(clients);

        by.edu.lesson.service.hibernate.ClientService clientServiceHibernate = new by.edu.lesson.service.hibernate.ClientService();
        List<PremiumClient> premiumClients = clientServiceHibernate.getPremiumClients();
        System.out.println(premiumClients);

        RoomService roomService = new RoomService();

        List<Room> rooms = roomService.addRoom(Arrays.asList(
                new Room(null, "Тренажёрный зал", "123", 10L, RoomStatus.ACTIVE, 800.10),
                new Room(null, "Тренажёрный зал", "321", 13L, RoomStatus.REPAIR, 3800.10),
                new Room(null, "Бассейн", "333", 30L, RoomStatus.ACTIVE, 200.10),
                new Room(null, "Сауна", "444", 150L, RoomStatus.ACTIVE, 2690.10)));
        System.out.println(rooms);

        List<SubselectRoom> roomWithMaxPeople = roomService.getRoomWithMaxPeople();
        System.out.println(roomWithMaxPeople);
    }

    public static void callExerciseSix() {
        ClientService service = new ClientService();
        Client client = service.searchById(52L);
        System.out.println(client);

        CompanyServiceService companyServiceService = new CompanyServiceService();
        List<CompanyService> companyService = companyServiceService.addCompanyService(Arrays.asList(
                new CompanyService(null, "Клининг", "25.24"),
                new CompanyService(null, "Фитнес тренеры", "35.24"),
                new CompanyService(null, "Баня", "22.24")));
        System.out.println("!----- Company services: " + companyService);

        RoomService roomService = new RoomService();
        List<Room> rooms = roomService.addRoom(Arrays.asList(
                new Room(null, "Тренажёрный зал", "123", 70L, RoomStatus.ACTIVE, 800.10),
                new Room(null, "Тренажёрный зал", "321", 170L, RoomStatus.REPAIR, 3800.10),
                new Room(null, "Бассейн", "333", 30L, RoomStatus.ACTIVE, 200.10),
                new Room(null, "Сауна", "444", 150L, RoomStatus.ACTIVE, 2690.10)
        ));
        System.out.println("!----- all-rooms: " + rooms);

        Room newRoom = roomService.addRoomWithNewIndfNumber(rooms.get(0), "999");
        System.out.println("!----- detached room: " + newRoom);

        Room changedRoom = roomService.changeAmountPerHour(rooms.get(1), 9898.01);
        System.out.println("!----- changed room: " + changedRoom);
    }*/

   /* public static void callExerciseFive() {
        ClientService clientService = new ClientService();
        clientService.addClient(Arrays.asList(
                new Client("Екотерина", "Котеевна", 18, "8-800-5553511",
                        LocalDateTime.now(), Status.ACTIVE, 14.00),
                new Client("Дмитрий", "Сикдеевич", 30, "8-800-5553535",
                        LocalDateTime.of(2002, 1, 22, 10, 2, 30), Status.BLOCKED, 22),
                new Client("Олег", "Подкрадулев", 15, "8-800-5553522",
                        LocalDateTime.of(2022, 2, 2, 10, 2, 30), Status.PREMIUM, 25.00),
                new Client("Алексей", "Шоркан", 58, "8-800-5553512",
                        LocalDateTime.of(2023, 8, 22, 10, 2, 30), Status.ACTIVE, 11),
                new Client("Сергей", "Эгегеевич", 37, "8-800-5553544",
                        LocalDateTime.of(2025, 4, 12, 10, 2, 30), Status.PREMIUM, 180.00)
        ));

        List<Client> clients = clientService.getAll();
        clientService.deleteClient(clients.get(0));
        clientService.changeClientStatus(3L, Status.BLOCKED);
    }*/
}