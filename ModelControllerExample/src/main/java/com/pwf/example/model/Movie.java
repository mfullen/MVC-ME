package com.pwf.example.model;

/**
 *
 * @author mfullen
 */
public class Movie
{
    private int id;
    private String title;
    private Genre genre;

    public Movie(int id, String title, Genre genre)
    {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public Movie()
    {
    }

    public Genre getGenre()
    {
        return genre;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "Movie{" + "id=" + id + ", title=" + title + ", genre=" + genre + '}';
    }
}
