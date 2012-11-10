package com.pwf.mvc;

import java.util.Collection;

/**
 * The Controller interface describes the methods required to be a controller.
 * It is based on a Model being manipulated and a ViewModel which is sent to any
 * UI's
 */
public interface Controller
{
    /**
     * Adds a postback Observer. Postback Observers get notified when data needs
     * to go from UI->Controller->X
     *
     * @param postBackObserver
     */
    <Model extends Object> void addPostbackObserver(PostBackObserver<Model> postBackObserver);

    /**
     * Add a viewObserver. View Observers get notified when a model is updated
     *
     * @param observer
     */
    <Model extends Object> void addViewObserver(View<Model> observer);

    /**
     * Get the PostbackObservers
     *
     * @return
     */
    <Model extends Object> Collection<PostBackObserver<Model>> getPostBackObservers();

    /**
     * Get the View Observers
     *
     * @return
     */
    <Model extends Object> Collection<View<Model>> getViewObservers();

    /**
     * Get a viewObserver by name
     *
     * @param name the name to look for
     * @return
     */
    <Model extends Object> View<Model> getView(String name) throws
            ViewNotFoundException;

    /**
     * Remove postBackObserver
     *
     * @param postBackObserver
     */
    <Model extends Object> void removePostbackObserver(PostBackObserver<Model> postBackObserver);

    /**
     * remove ViewObservers
     *
     * @param observer
     */
    <Model extends Object> void removeViewObserver(View<Model> observer);
}
