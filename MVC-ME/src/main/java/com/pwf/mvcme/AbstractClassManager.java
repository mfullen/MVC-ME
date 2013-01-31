package com.pwf.mvcme;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mfullen
 */
abstract class AbstractClassManager<N> implements Manager<N>
{
    private Set<N> controllers = new HashSet<N>();

    public void add(N controller)
    {
        controllers.add(controller);
    }

    public <T extends N> T get(Class<T> classname)
    {
        for (N controller : controllers)
        {
            if (classname.isAssignableFrom(controller.getClass()))
            {
                return (T) controller;
            }
        }
        return null;
    }

    public Collection<N> getAll()
    {
        return (Collection<N>) controllers;
    }

    public void remove(N controller)
    {
        controllers.remove(controller);
    }
}
