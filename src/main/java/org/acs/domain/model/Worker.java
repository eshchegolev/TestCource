package pack;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Сущность хранит информацию о департаменте, должность, расписание работы,
 * список времени входа/выхода.
 * */
@Entity
public class Worker extends User {
    @ManyToOne
    private Department department;
    private String position;
    private boolean isInside;
    @OneToOne
    private Schedule schedule;
    @OneToMany
    private List<EnterTime> enterTimes;
    @OneToMany
    private List<ExitTime> exitTime;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isInside() {
        return isInside;
    }

    public void setInside(boolean isInside) {
        this.isInside = isInside;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<EnterTime> getEnterTimes() {
        return enterTimes;
    }

    public void setEnterTimes(List<EnterTime> enterTimes) {
        this.enterTimes = enterTimes;
    }

    public List<ExitTime> getExitTime() {
        return exitTime;
    }

    public void setExitTime(List<ExitTime> exitTime) {
        this.exitTime = exitTime;
    }
}
