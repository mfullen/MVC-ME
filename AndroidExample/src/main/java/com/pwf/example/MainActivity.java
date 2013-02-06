package com.pwf.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import com.pwf.example.controller.MovieController;
import com.pwf.example.model.Movie;
import com.pwf.mvc.ControllersManager;
import com.pwf.mvc.MvcFramework;
import com.pwf.mvc.View;
import java.util.Collection;

public class MainActivity extends Activity
{
    private static String TAG = "AndroidExample";


    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
     * is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);

      
    }

}
