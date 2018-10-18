package org.acs.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Сущность хранит список времени входа/выхода
 * */
@Entity
public class Visitor extends User {
    private boolean isInside;
    @OneToMany
    private List<EnterTime> enterTimes;
    @OneToMany
    private List<ExitTime> exitTime;

    public boolean isInside() {
        return isInside;
    }

    public void setInside(boolean isInside) {
        this.isInside = isInside;
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
