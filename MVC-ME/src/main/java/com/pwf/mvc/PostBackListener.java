package com.pwf.mvc;

/**
 *
 * A PostBackListener is meant to send data from the UI to the controller then
 * pass it along to any listeners
 */
public interface PostBackListener<T>
{
    void postData(T model);
}
