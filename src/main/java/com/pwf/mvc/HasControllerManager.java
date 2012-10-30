
package com.pwf.mvc;

/**
 *
 * Describes having a ControllerManager
 */
public interface HasControllerManager
{
    /**
     * SetControllerManager
     *
     * @param controllerManager
     */
    void setControllerManager(ControllersManager controllerManager);

    /**
     * Get ControllerManager
     *
     * @return
     */
    ControllersManager getControllerManager();
}