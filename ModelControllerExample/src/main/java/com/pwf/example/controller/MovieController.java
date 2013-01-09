package com.pwf.example.controller;

import com.pwf.example.model.InMemoryMovieRepository;
import com.pwf.example.model.Movie;
import com.pwf.example.model.MovieRepository;
import com.pwf.mvc.AbstractController;
import com.pwf.mvc.ViewNotFoundException;

/**
 *
 * @author mfullen
 */
public class MovieController extends AbstractController
{
    public static final String MOVIE_CREATE = "create";
    public static final String MOVIE_EDIT = "edit";
    public static final String MOVIE_DELETE = "delete";
    public static final String MOVIE_INDEX = "Index";
    private MovieRepository movieRepository;

    public MovieController()
    {
        this(new InMemoryMovieRepository());
    }

    public MovieController(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public void index()
    {
        try
        {
            this.getView(MOVIE_INDEX).update(this.movieRepository.getAll());
        }
        catch (ViewNotFoundException ex)
        {
            this.updateErrorView(createViewNotFoundErrorMesage("Movie Index"));
        }
    }

    /**
     * GET
     */
    public void create()
    {
        try
        {
            this.getView(MOVIE_CREATE).update(new Movie());
        }
        catch (ViewNotFoundException ex)
        {
            this.updateErrorView(createViewNotFoundErrorMesage(MOVIE_CREATE));
        }
    }

    /**
     * POST DATA
     *
     * @param movie
     */
    public void created(Movie movie)
    {
        this.movieRepository.add(movie);
        this.movieRepository.save();
        this.index();
    }

    /**
     * GET
     *
     * @param id
     */
    public void edit(int id)
    {
        Movie movie = this.movieRepository.findById(id);
        try
        {
            this.getView(MOVIE_EDIT).update(movie);
        }
        catch (ViewNotFoundException ex)
        {
            this.updateErrorView(createViewNotFoundErrorMesage(MOVIE_EDIT));
        }
    }

    /**
     * POST
     *
     * @param movie
     */
    public void edited(Movie movie)
    {
        Movie emovie = this.movieRepository.findById(movie.getId());
        emovie.setGenre(movie.getGenre());
        emovie.setTitle(movie.getTitle());

        this.movieRepository.save();
        this.index();
    }

    /**
     * GET
     *
     * @param id
     */
    public void delete(int id)
    {
        Movie movie = this.movieRepository.findById(id);
        try
        {
            this.getView(MOVIE_DELETE).update(movie);
        }
        catch (ViewNotFoundException ex)
        {
            this.updateErrorView(createViewNotFoundErrorMesage(MOVIE_DELETE));
        }
    }

    /**
     * POST
     *
     * @param networkData
     */
    public void deleted(Movie movie)
    {
        Movie nd = this.movieRepository.findById(movie.getId());
        this.movieRepository.remove(nd);
        this.movieRepository.save();

        this.index();
    }
}
