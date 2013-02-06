package com.pwf.example;

import android.app.Activity;
import android.os.Bundle;
import com.pwf.example.controller.MovieController;
import com.pwf.example.model.Movie;
import com.pwf.mvcme.MvcFramework;
import com.pwf.mvcme.MvcMe;
import com.pwf.mvcme.View;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends Activity implements
        View<Collection<Movie>>
{
    private static Logger logger = LoggerFactory.getLogger(MainActivity.class);
    private MovieController controller;
    private MvcFramework mvcFramework;

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
        logger.debug("Android Example created");
        setContentView(R.layout.main);

        this.mvcFramework = MvcMe.createMvcFramework();
        mvcFramework.register(new MovieController());
    }

    @Override
    public String getName()
    {
        return MovieController.MOVIE_INDEX;
    }

    @Override
    public MvcFramework getMvcFramework()
    {
        return this.mvcFramework;
    }

    @Override
    public void setMvcFramework(MvcFramework cf)
    {
        this.mvcFramework = cf;

        this.controller = this.mvcFramework.getController(MovieController.class);
//        this.mvcFramework.register(new ErrorMessage());
//        this.mvcFramework.register(new ModifyMovie.CreateMovie());
//        this.mvcFramework.register(new ModifyMovie.EditMovie());
//        this.mvcFramework.register(new ModifyMovie.DeleteMovie());


        this.controller.index();
    }

    @Override
    public void update(Collection<Movie> t)
    {
        logger.info("Movie {}", t);
    }
}
