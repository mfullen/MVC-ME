
package com.pwf.mvc;

/**
 *
 * View interface to describe a View in the MVC Framework
 */
public interface View<T> extends HasControllerManager
{
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

    /**
     * Get the name of this View. This name should be unique
     *
     * @return String of the name for the view
     */
    String getName();
}
