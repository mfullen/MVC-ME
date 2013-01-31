package com.pwf.mvcme;

/**
 * The Controller interface describes the methods required to be a controller.
 * It is based on a Model being manipulated and a ViewModel which is sent to any
 * UI's
 */
public interface Controller extends NameProperty
{
    /**
     * Get a view by name
     *
     * @param name the name to look for
     * @return
     */
    <Model> View<Model> getView(String name);

    MvcFramework getMvcFramework();

    void setMvcFramework(MvcFramework viewFramework);
}
