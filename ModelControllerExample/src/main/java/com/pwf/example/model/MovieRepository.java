package com.pwf.example.model;

import com.pwf.mvcme.Repository;
import com.pwf.mvcme.Savable;

/**
 *
 * @author mfullen
 */
public interface MovieRepository extends Repository<Movie>,
                                         Savable
{
}
