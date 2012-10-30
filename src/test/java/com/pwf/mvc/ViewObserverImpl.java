// -----------------------------------------------------------------------------
// PWF Technology LLC
// -----------------------------------------------------------------------------
package com.pwf.mvc;

public class ViewObserverImpl implements View
{
    public ViewObserverImpl()
    {
    }

    public void update(Object t)
    {
        assert true;
    }

    public void setVisible(boolean bln)
    {
        assert true;
    }

    public void setControllerManager(ControllersManager controllerManager)
    {
        assert true;
    }

    public ControllersManager getControllerManager()
    {
        assert true;
        return null;
    }

    public String getName()
    {
        return "TestView";
    }
}
