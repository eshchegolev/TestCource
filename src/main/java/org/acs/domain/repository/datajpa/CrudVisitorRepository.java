package org.acs.domain.repository.datajpa;

import org.acs.domain.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudVisitorRepository extends JpaRepository<Visitor, Long> {
}
