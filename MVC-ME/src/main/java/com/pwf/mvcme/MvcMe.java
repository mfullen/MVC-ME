package com.pwf.mvcme;

import java.util.Collection;

/**
 *
 * @author mfullen
 */
public final class MvcMe implements MvcFramework
{
    private MvcMe()
    {
    }

    public static MvcFramework createMvcFramework()
    {
        return new MvcMe();
    }
    private Manager<View<?>> viewManager = new DefaultViewsManager();
    private Manager<Controller> controllerManager = new DefaultControllersManager();

    @Override
    public void register(View<?> view)
    {
        this.viewManager.add(view);
        view.setMvcFramework(this);
    }

    @Override
    public void register(Controller controller)
    {
        this.controllerManager.add(controller);
        controller.setMvcFramework(this);
    }

    @Override
    public void unregister(View<?> view)
    {
        this.viewManager.add(view);
    }

    @Override
    public void unregister(Controller controller)
    {
        this.controllerManager.add(controller);
    }

    @Override
    public <E extends View<?>> E getView(Class<E> type)
    {
        return (E) this.getView(type.getName());
    }

    @Override
    public <E extends Controller> E getController(Class<E> type)
    {
        return (E) this.getController(type.getName());
    }

    public View<?> getView(String name)
    {
        return this.viewManager.get(name);
    }

    public Controller getController(String name)
    {
        return this.controllerManager.get(name);
    }
//
//    public <E extends Controller> void link(Class<E> controllerClass, String method)
//    {
//    }
//
//
//    public <E extends Controller> void link(Class<E> controllerClass, String method, Object params)
//    {
//    }

    public Collection<View<?>> getAll()
    {
        return this.viewManager.getAll();
    }
}
