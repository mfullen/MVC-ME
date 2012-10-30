// -----------------------------------------------------------------------------
// PWF Technology LLC
// -----------------------------------------------------------------------------
package com.pwf.mvc;

public class PostBackObserverImpl implements PostBackObserver<Object>
{
    public PostBackObserverImpl()
    {
    }

    public void dataToPost(Object model)
    {
        assert model != null : "Model is null";
    }
}
