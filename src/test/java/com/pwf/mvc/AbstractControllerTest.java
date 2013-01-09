package com.pwf.mvc;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;
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
     * Test of addViewListener method, of class AbstractController.
     */
    @Test
    public void testAddViewObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViews().size());
        controller.addViewListener(new ViewImpl());
        assertEquals(1, controller.getViews().size());
    }

    /**
     * Test of removeViewObserver method, of class AbstractController.
     */
    @Test
    public void testRemoveViewObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViews().size());
        ViewImpl viewObserverImpl = new ViewImpl();
        controller.addViewListener(viewObserverImpl);
        assertEquals(1, controller.getViews().size());
        controller.removeViewObserver(viewObserverImpl);
        assertEquals(0, controller.getViews().size());
    }

    /**
     * Test of addPostbackListener method, of class AbstractController.
     */
    @Test
    public void testAddPostbackObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getPostBackListeners().size());
        PostBackListener<Object> postBackObserver = new PostBackListenerImpl();
        controller.addPostbackListener(postBackObserver);
        assertEquals(1, controller.getPostBackListeners().size());
    }

    /**
     * Test of removePostbackListener method, of class AbstractController.
     */
    @Test
    public void testRemovePostbackObserver()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getPostBackListeners().size());
        PostBackListener<Object> postBackObserver = new PostBackListenerImpl();
        controller.addPostbackListener(postBackObserver);
        assertEquals(1, controller.getPostBackListeners().size());
        controller.removePostbackListener(postBackObserver);
        assertEquals(0, controller.getPostBackListeners().size());
    }

    /**
     * Test of firePostBackData method, of class AbstractController.
     */
    @Test
    public void testFirePostBackData()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getPostBackListeners().size());
        PostBackListener<Object> postBackObserver = new PostBackListenerImpl();
        controller.addPostbackListener(postBackObserver);
        assertEquals(1, controller.getPostBackListeners().size());
        controller.firePostBackData(new Object());
    }

    /**
     * Test of fireUpdateView method, of class AbstractController.
     */
    @Test
    public void testFireUpdateView()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViews().size());
        controller.addViewListener(new ViewImpl());
        assertEquals(1, controller.getViews().size());
        controller.fireUpdateView(new Object());
    }

    /**
     * Test of fireSetVisible method, of class AbstractController.
     */
    @Test
    public void testFireSetVisible()
    {
        AbstractController controller = new AbstractControllerImpl();
        assertEquals(0, controller.getViews().size());
        controller.addViewListener(new ViewImpl());
        assertEquals(1, controller.getViews().size());
        controller.fireSetVisible(true);
        controller.fireSetVisible(false);
    }

    public class AbstractControllerImpl extends AbstractController
    {
    }
}
