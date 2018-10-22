package org.acs.domain.repository.datajpa;

import org.acs.domain.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudWorkerRepository extends JpaRepository<Worker, Long> {
}
