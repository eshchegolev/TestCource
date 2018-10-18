package pack;

import javax.persistence.*;
import java.util.Collection;

/**
 * Суперкласс для Worker, Visitor, VirtualUser
 * */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
