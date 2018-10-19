package org.acs.domain.repository;

import org.acs.domain.model.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);

    boolean delete(int id);

    Schedule get(int id);

    List <Schedule> getAll();
}
