package com.pwf.mvcme;

import java.util.Collection;

/**
 * Repository Interface to expose basic functionality for a repository
 *
 * @param <T> The Model Entity the Repository deals with
 */
public interface Repository<T>
{
    /**
     * Add the Model Entity T to the repository
     *
     * @param model The Model Entity to create
     */
    void create(T model);

    /**
     * Remove the Model Entity from the repository
     *
     * @param model the Model Entity to delete
     */
    void delete(T model);

    /**
     * Get all the Model Entities in the Repository as a Collection
     *
     * @return a Collection of T
     */
    Collection<T> getAll();

    /**
     * Get the Model Entity based on an id
     *
     * @param id the identifier to use
     * @return A Model Entity
     */
    T get(int id);

    /**
     * Remove all Model Entities in the repository
     */
    void deleteAll();
}
