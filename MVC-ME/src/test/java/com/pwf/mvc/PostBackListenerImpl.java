// -----------------------------------------------------------------------------
// PWF Technology LLC
// -----------------------------------------------------------------------------
package com.pwf.mvc;

public class PostBackListenerImpl implements PostBackListener<Object>
{
    public PostBackListenerImpl()
    {
    }

    public void postData(Object model)
    {
        assert model != null : "Model is null";
    }
}
