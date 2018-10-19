package org.acs.domain.repository;

import org.acs.domain.model.Visitor;

import java.util.List;

public interface VisitorRepository {
    Visitor save(Visitor visitor);

    boolean delete(int id);

    Visitor get(int id);

    List<Visitor> getAll();
}
