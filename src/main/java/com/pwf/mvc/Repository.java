
package com.pwf.mvc;

import java.util.Collection;

/**
 * Repository Interface to expose basic functionality for a repository
 *
 * @param <T> The Model the Repository deals with
 */
public interface Repository<T>
{
    /**
     * Add the Model T to the repository
     *
     * @param model The model to add
     */
    void add(T model);

    /**
     * Remove the model from the repository
     *
     * @param model the model to remove
     */
    void remove(T model);

    /**
     * Get all the Models in the Repository as a Collection
     *
     * @return a Collection of T
     */
    Collection<T> getAll();

    /**
     * Get the model based on an id
     *
     * @param id the identifier to use
     * @return A Model
     */
    T findById(int id);

    /**
     * Remove all models in the repository
     */
    void removeAll();

    /**
     * Save operation for the repository
     */
    void save();
}
