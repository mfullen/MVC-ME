package com.pwf.mvc;

/**
 *
 * @author mfullen
 */
public final class MvcFramework
{
    private MvcFramework()
    {
    }

    public static ControllersManager createControllersManager()
    {
        return new DefaultControllersManager();
    }
}
