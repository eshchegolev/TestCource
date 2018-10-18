package pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Сущность хранит дату, время начала/конца работы.
 * Используется Worker' ом.
 * */
@Entity
public class Schedule {
    @Id
    private long id;
    private Date date;
    private Timestamp startOfDuty;
    private Timestamp endOfDuty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getStartOfDuty() {
        return startOfDuty;
    }

    public void setStartOfDuty(Timestamp startOfDuty) {
        this.startOfDuty = startOfDuty;
    }

    public Timestamp getEndOfDuty() {
        return endOfDuty;
    }

    public void setEndOfDuty(Timestamp endOfDuty) {
        this.endOfDuty = endOfDuty;
    }
}
