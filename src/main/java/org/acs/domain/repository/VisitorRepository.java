package org.acs.domain.repository;

import org.acs.domain.model.Visitor;

import java.util.List;

/**
 * The interface with a generalized functional for visitor's repository.
 *
 * @author Glushkov Evgeniy
 * @version 1.0
 */
public interface VisitorRepository {
    /**
     * Saves or updates a given visitor.
     *
     * @param visitor visitor to save or update.
     * @return a saved or update visitor,
     * null - if there aren't updated visitor in the repository.
     */
    Visitor save(Visitor visitor);

    /**
     * Deletes the visitor with specifiec id.
     *
     * @param id the specifiec id of a deleted visitor.
     * @return true - if a visitor with the specifiec id are deleted,
     * false - if there aren't the visitor with the cpecifiec id in the DB.
     */
    boolean delete(int id);

    /**
     * Returnes a visitor with the cpecifiec id.
     *
     * @param id the specifiec id of visitor to get.
     * @return a visitor with the cpecifiec id,
     * null - if there aren't visitor with cpecifiec id  in the DB.
     */
    Visitor get(int id);

    /**
     * Returnes list with all visitors.
     *
     * @return list with all visitors.
     */
    List<Visitor> getAll();
}
