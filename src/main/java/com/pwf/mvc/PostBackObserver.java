
package com.pwf.mvc;

/**
 *
 * A postback Observer is meant to send data from the UI to the controller then
 * pass it along to any listeners
 */
public interface PostBackObserver<T>
{
    void dataToPost(T model);
}
