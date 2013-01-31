package com.pwf.mvcme;

/**
 *
 * View interface to describe a View in the MVC Framework
 */
public interface View<T> extends NameProperty
{
    static final String ERROR_VIEW_ID = "error";

    /**
     * Update the view based on the model T
     *
     * @param model the model being passed to the view
     */
    void update(T model);

    /**
     * Set the visibility of the view
     *
     * @param visible
     */
    void setVisible(boolean visible);

    MvcFramework getMvcFramework();

    void setMvcFramework(MvcFramework mvcFramework);
}
