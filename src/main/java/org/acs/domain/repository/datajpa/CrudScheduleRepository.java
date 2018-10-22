package org.acs.domain.repository.datajpa;

import org.acs.domain.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudScheduleRepository extends JpaRepository<Schedule, Long> {
}
