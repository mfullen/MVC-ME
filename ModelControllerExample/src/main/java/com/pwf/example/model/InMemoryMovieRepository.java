package com.pwf.example.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mfullen
 */
public class InMemoryMovieRepository implements MovieRepository
{
    private Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();

    public InMemoryMovieRepository()
    {
        int index = 0;
        this.create(new Movie(++index, "Die Hard", Genre.ACTION));
        this.create(new Movie(++index, "Terminator", Genre.ACTION));
        this.create(new Movie(++index, "Nutty Professor", Genre.COMEDY));
        this.create(new Movie(++index, "Scream", Genre.HORROR));

    }

    public final void create(Movie model)
    {
        if (this.movieMap.containsKey(model.getId()))
        {
            model.setId(this.getNextId());
        }
        this.movieMap.put(model.getId(), model);
    }

    protected int getNextId()
    {
        int id = 1;

        idLabel:
        while (true)
        {
            if (!this.movieMap.containsKey(id))
            {
                break idLabel;
            }
            id++;
        }
        return id;
    }

    public void delete(Movie model)
    {
        this.movieMap.remove(model.getId());
    }

    public Collection<Movie> getAll()
    {
        return this.movieMap.values();
    }

    public Movie get(int id)
    {
        return this.movieMap.get(id);
    }

    public void deleteAll()
    {
        this.movieMap.clear();
    }

    public void save()
    {
        //nothing to do here
    }
}
