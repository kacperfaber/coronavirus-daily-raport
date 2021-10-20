package io.github.kacperfaber.history;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class HistoryLog {
    private int id;
    private Timestamp createdAt;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
