package org.acs.domain.repository;


import org.acs.domain.model.Worker;

import java.util.List;

public interface WorkerRepository {
    Worker save(Worker worker);

    boolean delete(int id);

    Worker get(int id);

    List <Worker> getAll();

    List <Worker> getAllByDepId(int depId);
}
