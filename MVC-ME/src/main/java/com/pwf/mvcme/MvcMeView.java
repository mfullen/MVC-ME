package com.pwf.mvcme;

/**
 *
 * @author mfullen
 */
public abstract class MvcMeView<Model> implements View<Model>
{
    private MvcFramework mvcFramework;

    public abstract void update(Model model);

    public void setVisible(boolean visible)
    {
        //do nothing
    }

    public MvcFramework getMvcFramework()
    {
        return this.mvcFramework;
    }

    public void setMvcFramework(MvcFramework controllerFramework)
    {
        this.mvcFramework = controllerFramework;
    }

    public String getName()
    {
        return this.getClass().getCanonicalName();
    }
}
