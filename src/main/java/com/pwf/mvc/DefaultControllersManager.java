package com.pwf.mvc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class DefaultControllersManager implements ControllersManager
{
    private Set<Controller> controllers = new HashSet<Controller>();

    @Override
    public void addController(Controller controller)
    {
        controllers.add(controller);
    }

    @Override
    public <T extends Controller> T getController(Class<T> classname)
    {
        for (Controller controller : controllers)
        {
            if (classname.isAssignableFrom(controller.getClass()))
            {
                return (T) controller;
            }
        }
        return null;
    }

    @Override
    public <T extends Controller> Collection<T> getAllControllers()
    {
        return (Collection<T>) controllers;
    }

    @Override
    public void removeController(Controller controller)
    {
        controllers.remove(controller);
    }
}
