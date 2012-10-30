/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwf.mvc;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author mfullen
 */
public class AbstractControllerTest
{
    public AbstractControllerTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    /**
     * Test of addViewObserver method, of class AbstractController.
     */
    @Test
    public void testAddViewObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViewObservers().size());
        controller.addViewObserver(new ViewObserverImpl());
        assertEquals(1, controller.getViewObservers().size());
    }

    /**
     * Test of removeViewObserver method, of class AbstractController.
     */
    @Test
    public void testRemoveViewObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViewObservers().size());
        ViewObserverImpl viewObserverImpl = new ViewObserverImpl();
        controller.addViewObserver(viewObserverImpl);
        assertEquals(1, controller.getViewObservers().size());
        controller.removeViewObserver(viewObserverImpl);
        assertEquals(0, controller.getViewObservers().size());
    }

    /**
     * Test of addPostbackObserver method, of class AbstractController.
     */
    @Test
    public void testAddPostbackObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getPostBackObservers().size());
        PostBackObserver<Object> postBackObserver = new PostBackObserverImpl();
        controller.addPostbackObserver(postBackObserver);
        assertEquals(1, controller.getPostBackObservers().size());
    }

    /**
     * Test of removePostbackObserver method, of class AbstractController.
     */
    @Test
    public void testRemovePostbackObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getPostBackObservers().size());
        PostBackObserver<Object> postBackObserver = new PostBackObserverImpl();
        controller.addPostbackObserver(postBackObserver);
        assertEquals(1, controller.getPostBackObservers().size());
        controller.removePostbackObserver(postBackObserver);
        assertEquals(0, controller.getPostBackObservers().size());
    }

    /**
     * Test of firePostBackData method, of class AbstractController.
     */
    @Test
    public void testFirePostBackData()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getPostBackObservers().size());
        PostBackObserver<Object> postBackObserver = new PostBackObserverImpl();
        controller.addPostbackObserver(postBackObserver);
        assertEquals(1, controller.getPostBackObservers().size());
        controller.firePostBackData(new Object());
    }

    /**
     * Test of fireUpdateView method, of class AbstractController.
     */
    @Test
    public void testFireUpdateView()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViewObservers().size());
        controller.addViewObserver(new ViewObserverImpl());
        assertEquals(1, controller.getViewObservers().size());
        controller.fireUpdateView(new Object());
    }

    /**
     * Test of fireSetVisible method, of class AbstractController.
     */
    @Test
    public void testFireSetVisible()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViewObservers().size());
        controller.addViewObserver(new ViewObserverImpl());
        assertEquals(1, controller.getViewObservers().size());
        controller.fireSetVisible(true);
        controller.fireSetVisible(false);
    }

    public class AbstractControllerImpl extends AbstractController
    {
    }
}
