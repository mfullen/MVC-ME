package com.pwf.mvc;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 */
public class DefaultControllersManagerTest
{
    class SubOfAbstractController extends AbstractController
    {
    };

    class SubOfSubOfAbstractController extends SubOfAbstractController
    {
    };

    @Test
    public void testAddController()
    {
        DefaultControllersManager instance = new DefaultControllersManager();
        instance.addController(new SubOfAbstractController());
        assertNotNull(instance.getController(SubOfAbstractController.class));
    }

    @Test
    public void testAddController2()
    {
        DefaultControllersManager instance = new DefaultControllersManager();
        instance.addController(new SubOfSubOfAbstractController());
        assertNotNull(instance.getController(SubOfAbstractController.class));
    }

    @Test
    public void testAddController3()
    {
        DefaultControllersManager instance = new DefaultControllersManager();
        instance.addController(new SubOfAbstractController());
        instance.addController(new SubOfSubOfAbstractController());
        assertNotNull(instance.getController(SubOfAbstractController.class));
    }

    @Test
    public void testAddController4()
    {
        DefaultControllersManager instance = new DefaultControllersManager();
        assertNull(instance.getController(SubOfAbstractController.class));
    }

    @Test
    public void testGetAllControllers()
    {
        DefaultControllersManager instance = new DefaultControllersManager();
        instance.addController(new SubOfAbstractController());
        instance.addController(new SubOfSubOfAbstractController());
        assertEquals(2, instance.getAllControllers().size());
    }

    @Test
    public void testRemoveController()
    {
        DefaultControllersManager instance = new DefaultControllersManager();
        SubOfAbstractController subOfAbstractController = new SubOfAbstractController();
        instance.addController(subOfAbstractController);
        instance.addController(new SubOfSubOfAbstractController());
        instance.removeController(subOfAbstractController);
        assertEquals(1, instance.getAllControllers().size());
    }
}
