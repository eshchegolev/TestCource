package org.acs.domain.repository.datajpa;

import org.acs.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudDepartmentRepository extends JpaRepository<Department, Long> {

}
