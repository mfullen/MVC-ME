package com.pwf.mvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 */
public abstract class AbstractController implements Controller
{
    private Map<String, View<? extends Object>> viewsMap = new HashMap<String, View<? extends Object>>();
    private Collection<PostBackListener<? extends Object>> postBackListeners = new ArrayList<PostBackListener<? extends Object>>();

    @Override
    public <Model extends Object> void addViewListener(View<Model> view)
    {
        this.viewsMap.put(view.getName(), view);
    }

    @Override
    public <Model extends Object> void removeViewObserver(View<Model> view)
    {
        this.viewsMap.remove(view.getName());
    }

    @Override
    public <Model extends Object> void addPostbackListener(PostBackListener<Model> postBackListener)
    {
        this.postBackListeners.add(postBackListener);
    }

    @Override
    public <Model extends Object> void removePostbackListener(PostBackListener<Model> postBackListener)
    {
        this.postBackListeners.remove(postBackListener);
    }

    protected <Model extends Object> void firePostBackData(Model model)
    {
        for (Iterator<PostBackListener<? extends Object>> it = postBackListeners.iterator(); it.hasNext();)
        {
            PostBackListener<Model> postBackObserver = (PostBackListener<Model>) it.next();
            postBackObserver.postData(model);
        }
    }

    protected <Model extends Object> void fireUpdateView(Model model)
    {
        for (Iterator<View<? extends Object>> it = viewsMap.values().iterator(); it.hasNext();)
        {
            View<Model> viewObserver = (View<Model>) it.next();
            viewObserver.update(model);
        }
    }

    protected <Model extends Object> void fireSetVisible(boolean visible)
    {
        for (Iterator<View<? extends Object>> it = viewsMap.values().iterator(); it.hasNext();)
        {
            View<Model> viewObserver = (View<Model>) it.next();
            viewObserver.setVisible(visible);
        }
    }

    public <Model extends Object> View<Model> getView(String name) 
    {
        View<Model> view = (View<Model>) this.viewsMap.get(name);
        if (view == null)
        {
            throw new ViewNotFoundException(createViewNotFoundErrorMesage(name));
        }
        return view;
    }

    @Override
    public <Model extends Object> Collection<View<Model>> getViews()
    {
        Collection<View<Model>> values = new ArrayList<View<Model>>(this.viewsMap.values().size());
        for (View<? extends Object> view : this.viewsMap.values())
        {
            values.add((View<Model>) view);
        }

        return Collections.unmodifiableCollection(values);
    }

    @Override
    public <Model extends Object> Collection<PostBackListener<Model>> getPostBackListeners()
    {
        Collection<PostBackListener<Model>> values = new ArrayList<PostBackListener<Model>>(this.postBackListeners.size());
        for (PostBackListener<? extends Object> postBackObserver : this.postBackListeners)
        {
            values.add((PostBackListener<Model>) postBackObserver);
        }

        return Collections.unmodifiableCollection(values);
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
}
