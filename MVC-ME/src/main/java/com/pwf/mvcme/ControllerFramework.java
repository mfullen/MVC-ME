package com.pwf.mvcme;

/**
 *
 * @author mfullen
 */
interface ControllerFramework
{
    /**
     *
     * @param <E>
     * @param type
     * @return
     */
    <E extends Controller> E getController(Class<E> type);

    /**
     *
     * @param name
     * @return
     */
    Controller getController(String name);

    /**
     *
     * @param controller
     */
    void register(Controller controller);

    /**
     *
     * @param controller
     */
    void unregister(Controller controller);
}
