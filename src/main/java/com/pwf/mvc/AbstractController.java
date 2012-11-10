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
    private Map<String, View<? extends Object>> observers = new HashMap<String, View<? extends Object>>();
    private Collection<PostBackObserver<? extends Object>> postBackObservers = new ArrayList<PostBackObserver<? extends Object>>();

    @Override
    public <Model extends Object> void addViewObserver(View<Model> observer)
    {
        this.observers.put(observer.getName(), observer);
    }

    @Override
    public <Model extends Object> void removeViewObserver(View<Model> observer)
    {
        this.observers.remove(observer.getName());
    }

    @Override
    public <Model extends Object> void addPostbackObserver(PostBackObserver<Model> postBackObserver)
    {
        this.postBackObservers.add(postBackObserver);
    }

    @Override
    public <Model extends Object> void removePostbackObserver(PostBackObserver<Model> postBackObserver)
    {
        this.postBackObservers.remove(postBackObserver);
    }

    protected <Model extends Object> void firePostBackData(Model model)
    {
        for (Iterator<PostBackObserver<? extends Object>> it = postBackObservers.iterator(); it.hasNext();)
        {
            PostBackObserver<Model> postBackObserver = (PostBackObserver<Model>) it.next();
            postBackObserver.dataToPost(model);
        }
    }

    protected <Model extends Object> void fireUpdateView(Model model)
    {
        for (Iterator<View<? extends Object>> it = observers.values().iterator(); it.hasNext();)
        {
            View<Model> viewObserver = (View<Model>) it.next();
            viewObserver.update(model);
        }
    }

    protected <Model extends Object> void fireSetVisible(boolean visible)
    {
        for (Iterator<View<? extends Object>> it = observers.values().iterator(); it.hasNext();)
        {
            View<Model> viewObserver = (View<Model>) it.next();
            viewObserver.setVisible(visible);
        }
    }

    public <Model extends Object> View<Model> getView(String name) throws
            ViewNotFoundException
    {
        View<Model> view = (View<Model>) this.observers.get(name);
        if (view == null)
        {
            throw new ViewNotFoundException("The view (" + name + ") could not be found");
        }
        return view;
    }

    @Override
    public <Model extends Object> Collection<View<Model>> getViewObservers()
    {
        Collection<View<Model>> values = new ArrayList<View<Model>>(this.observers.values().size());
        for (View<? extends Object> view : this.observers.values())
        {
            values.add((View<Model>) view);
        }

        return Collections.unmodifiableCollection(values);
    }

    @Override
    public <Model extends Object> Collection<PostBackObserver<Model>> getPostBackObservers()
    {
        Collection<PostBackObserver<Model>> values = new ArrayList<PostBackObserver<Model>>(this.postBackObservers.size());
        for (PostBackObserver<? extends Object> postBackObserver : this.postBackObservers)
        {
            values.add((PostBackObserver<Model>) postBackObserver);
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
