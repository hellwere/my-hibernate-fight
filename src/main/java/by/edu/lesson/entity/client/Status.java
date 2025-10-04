package by.edu.lesson.entity.client;

public enum Status {
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED"),
    PREMIUM("PREMIUM");

    final String value;

    Status(String value) {
        this.value = value;
    }
}
