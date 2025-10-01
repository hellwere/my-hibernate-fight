package by.edu.lesson;

import by.edu.lesson.entity.Client;
import by.edu.lesson.entity.Status;
import by.edu.lesson.service.ClientService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
    }
}