package io.github.kacperfaber.api;

import java.sql.Timestamp;

public class Subscription {
    private int id;
    private String email;
    private String confirmationCode;
    private Timestamp createdAt;
    private Timestamp confirmedAt;
    private Timestamp canceledAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Timestamp confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public void setCanceledAt(Timestamp canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Timestamp getCanceledAt() {
        return this.canceledAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (confirmationCode != null ? !confirmationCode.equals(that.confirmationCode) : that.confirmationCode != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (confirmedAt != null ? !confirmedAt.equals(that.confirmedAt) : that.confirmedAt != null) return false;
        if (canceledAt != null ? !canceledAt.equals(that.canceledAt) : that.canceledAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (confirmationCode != null ? confirmationCode.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (confirmedAt != null ? confirmedAt.hashCode() : 0);
        result = 31 * result + (canceledAt != null ? canceledAt.hashCode() : 0);
        return result;
    }
}
