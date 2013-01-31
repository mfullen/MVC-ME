package com.pwf.mvcme;

/**
 *
 * A PostBackListener is meant to send data from the UI to the controller then
 * pass it along to any listeners
 */
interface PostBackListener<T>
{
    void postData(T model);
}
