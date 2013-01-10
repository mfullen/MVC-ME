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

public class MainActivity extends Activity implements
        View<Collection<Movie>>
{
    private static String TAG = "AndroidExample";
    private ControllersManager controllersManager;

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

        ControllersManager cm = MvcFramework.createControllersManager();
        cm.addController(new MovieController());

        this.setControllerManager(cm);
        MovieController controller = cm.getController(MovieController.class);
        controller.addViewListener(this);
        controller.index();
    }

    @Override
    public void update(Collection<Movie> movies)
    {
        Log.i(TAG, movies + "");
        //ArrayAdapter<Movie> arrayAdapter = new ArrayAdapter<Movie>(this, R.layout.main, movies.toArray(new Movie[movies.size()]));
        //this.setListAdapter(arrayAdapter);
    }

    @Override
    public String getName()
    {
        return MovieController.MOVIE_INDEX;
    }

    @Override
    public void setControllerManager(ControllersManager cm)
    {
        this.controllersManager = cm;
    }

    @Override
    public ControllersManager getControllerManager()
    {
        return this.controllersManager;
    }
}
