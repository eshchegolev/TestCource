package org.acs.domain.repository.datajpa.impl;

import org.acs.domain.model.Department;
import org.acs.domain.repository.DepartmentRepository;
import org.acs.domain.repository.datajpa.CrudDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DataJpa implementation of the DepartmentRepository.
 */
@Repository
public class DataJpaDepartmentRepositoryImpl implements DepartmentRepository {
    private static final Sort SORT_NAME = new Sort(Sort.Direction.ASC, "name");

    @Autowired
    CrudDepartmentRepository crudRepository;

    @Override
    public Department save(Department department) {
        return crudRepository.save(department);
    }

    @Override
    public boolean delete(long id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Department get(long id) {
        return crudRepository.getOne(id);
    }

    @Override
    public List<Department> getAll() {
        return crudRepository.findAll(SORT_NAME);
    }
}
