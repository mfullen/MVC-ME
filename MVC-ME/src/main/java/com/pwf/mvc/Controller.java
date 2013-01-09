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
     * Adds a PostBackListener. PostBackListener get notified when data needs to
     * go from UI->Controller->X
     *
     * @param postBackListener
     */
    <Model extends Object> void addPostbackListener(PostBackListener<Model> postBackListener);

    /**
     * Add a view. View get notified when a model is updated
     *
     * @param view
     */
    <Model extends Object> void addViewListener(View<Model> view);

    /**
     * Get the postBackListeners
     *
     * @return
     */
    <Model extends Object> Collection<PostBackListener<Model>> getPostBackListeners();

    /**
     * Get the Views
     *
     * @return
     */
    <Model extends Object> Collection<View<Model>> getViews();

    /**
     * Get a view by name
     *
     * @param name the name to look for
     * @return
     */
    <Model extends Object> View<Model> getView(String name);

    /**
     * Remove postBackListener
     *
     * @param postBackListener
     */
    <Model extends Object> void removePostbackListener(PostBackListener<Model> postBackListener);

    /**
     * remove View
     *
     * @param view
     */
    <Model extends Object> void removeViewObserver(View<Model> view);
}
