package com.pwf.mvcme;

public class ViewNotFoundException extends RuntimeException
{
    public ViewNotFoundException(String message)
    {
        super(message);
    }
}
