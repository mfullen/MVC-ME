
package com.pwf.mvc;

public class ViewNotFoundException extends RuntimeException
{
    public ViewNotFoundException(String message)
    {
        super(message);
    }
}
