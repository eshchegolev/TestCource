package pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Сущность хранит имя департамента, в котором работает Worker, а так же
 * список рабочих в департаменте.
 * */
@Entity
public class Department {
    @Id
    private long id;
    private String name;
    @OneToMany
    private List<Worker> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getUsers() {
        return users;
    }

    public void setUsers(List<Worker> users) {
        this.users = users;
    }
}
