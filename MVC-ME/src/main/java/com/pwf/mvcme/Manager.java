package com.pwf.mvcme;

import java.util.Collection;

/**
 *
 * A Ts Manager handles the registered controllers in the framework
 */
interface Manager<T>
{
    /**
     * Add a T
     *
     * @param controller
     */
    public void add(T controller);

    /**
     * Remove a T
     *
     * @param controller
     */
    public void remove(T controller);

    public T get(String name);

    public Collection<T> getAll();
}
