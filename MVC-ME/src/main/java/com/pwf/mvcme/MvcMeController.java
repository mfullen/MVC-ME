package com.pwf.mvcme;

/**
 *
 */
public abstract class MvcMeController implements Controller
{
    private MvcFramework mvcFramework;

    public <Model> View<Model> getView(String name)
    {
        View<Model> view = (View<Model>) this.mvcFramework.getView(name);
        if (view == null)
        {
            throw new ViewNotFoundException(createViewNotFoundErrorMesage(name));
        }
        return view;
    }

    protected void updateErrorView(String errorMessage)
    {
        try
        {
            this.getView(View.ERROR_VIEW_ID).update(errorMessage);
        }
        catch (ViewNotFoundException ex)
        {
        }
    }

    protected String createViewNotFoundErrorMesage(String viewName)
    {
        return "View Id (" + viewName + ") not registered in the class " + this.getClass().getName();
    }

    /**
     *
     * @return
     */
    public MvcFramework getMvcFramework()
    {
        return mvcFramework;
    }

    public void setMvcFramework(MvcFramework viewFramework)
    {
        this.mvcFramework = viewFramework;
    }

    public String getName()
    {
        return this.getClass().getName();
    }
}
