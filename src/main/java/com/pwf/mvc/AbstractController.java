
package com.pwf.mvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aorozc01
 */
public abstract class AbstractController<Model, ViewModel> implements Controller<Model, ViewModel>
{
    private Map<String, View<ViewModel>> observers = new HashMap<String, View<ViewModel>>();
    private Collection<PostBackObserver<Model>> postBackObservers = new ArrayList<PostBackObserver<Model>>();

    @Override
    public void addViewObserver(View<ViewModel> observer)
    {
        this.observers.put(observer.getName(), observer);
    }

    @Override
    public void removeViewObserver(View<ViewModel> observer)
    {
        this.observers.remove(observer.getName());
    }

    @Override
    public void addPostbackObserver(PostBackObserver<Model> postBackObserver)
    {
        this.postBackObservers.add(postBackObserver);
    }

    @Override
    public void removePostbackObserver(PostBackObserver<Model> postBackObserver)
    {
        this.postBackObservers.remove(postBackObserver);
    }

    protected void firePostBackData(Model model)
    {
        for (PostBackObserver<Model> postBackObserver : postBackObservers)
        {
            postBackObserver.dataToPost(model);
        }
    }

    protected void fireUpdateView(ViewModel model)
    {
        for (View<ViewModel> viewObserver : observers.values())
        {
            viewObserver.update(model);
        }
    }

    protected void fireSetVisible(boolean visible)
    {
        for (View<ViewModel> viewObserver : observers.values())
        {
            viewObserver.setVisible(visible);
        }
    }

    public View<ViewModel> getView(String name) throws ViewNotFoundException
    {
        View<ViewModel> view = this.observers.get(name);
        if (view == null)
        {
            throw new ViewNotFoundException("The view (" + name + ") could not be found");
        }
        return view;
    }

    @Override
    public Collection<View<ViewModel>> getViewObservers()
    {
        return Collections.unmodifiableCollection(this.observers.values());
    }

    @Override
    public Collection<PostBackObserver<Model>> getPostBackObservers()
    {
        return Collections.unmodifiableCollection(this.postBackObservers);
    }
}
