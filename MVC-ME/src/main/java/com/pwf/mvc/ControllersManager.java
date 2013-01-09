
package com.pwf.mvc;

import java.util.Collection;

/**
 *
 * A Controllers Manager handles the registered controllers in the framework
 */
public interface ControllersManager
{
    /**
     * Add a Controller
     *
     * @param controller
     */
    public void addController(Controller controller);

    /**
     * Remove a Controller
     *
     * @param controller
     */
    public void removeController(Controller controller);

    /**
     * Get a controller based on its class type
     *
     * @param <T>
     * @param type
     * @return
     */
    public <T extends Controller> T getController(Class<T> type);

    /**
     * Get all the Registered Controllers
     *
     * @param <T>
     * @return
     */
    public <T extends Controller> Collection<T> getAllControllers();
}
