package by.edu.lesson.entity;

public enum Status {
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED"),
    PREMIUM("PREMIUM");

    final String value;

    Status(String value) {
        this.value = value;
    }
}
