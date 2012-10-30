
package com.pwf.mvc;

import java.util.Collection;

/**
 * The Controller interface describes the methods required to be a controller. It is based on a Model being manipulated
 * and a ViewModel which is sent to any UI's
 */
public interface Controller<Model, ViewModel>
{
    /**
     * Adds a postback Observer. Postback Observers get notified when data needs to go from UI->Controller->X
     *
     * @param postBackObserver
     */
    void addPostbackObserver(PostBackObserver<Model> postBackObserver);

    /**
     * Add a viewObserver. View Observers get notified when a model is updated
     *
     * @param observer
     */
    void addViewObserver(View<ViewModel> observer);

    /**
     * Get the PostbackObservers
     *
     * @return
     */
    Collection<PostBackObserver<Model>> getPostBackObservers();

    /**
     * Get the View Observers
     *
     * @return
     */
    Collection<View<ViewModel>> getViewObservers();

    /**
     * Get a viewObserver by name
     *
     * @param name the name to look for
     * @return
     */
    View<ViewModel> getView(String name) throws ViewNotFoundException;

    /**
     * Remove postBackObserver
     *
     * @param postBackObserver
     */
    void removePostbackObserver(PostBackObserver<Model> postBackObserver);

    /**
     * remove ViewObservers
     *
     * @param observer
     */
    void removeViewObserver(View<ViewModel> observer);
}
