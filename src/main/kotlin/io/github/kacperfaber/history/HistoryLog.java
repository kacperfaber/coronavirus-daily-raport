package io.github.kacperfaber.history;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class HistoryLog {
    private int id;
    private LocalDateTime createdAt;
    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryLog that = (HistoryLog) o;
        return id == that.id && Objects.equals(createdAt, that.createdAt) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, date);
    }
}
