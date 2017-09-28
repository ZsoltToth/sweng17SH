package hu.uni.miskolc.iit.sweng.core.service;

import hu.uni.miskolc.iit.sweng.core.model.Actor;
import hu.uni.miskolc.iit.sweng.core.model.Genre;
import hu.uni.miskolc.iit.sweng.core.model.Movie;
import hu.uni.miskolc.iit.sweng.core.service.exceptions.ExistingTitleException;
import hu.uni.miskolc.iit.sweng.core.service.exceptions.MovieNotFoundException;

import java.util.Collection;
import java.util.Date;

/**
 * Created by tothzs on 2017.09.28..
 */
public interface MovieManagerService {

    public Collection<Movie> listAllMovies();
    public Collection<Movie> listMoviesByGenre(Genre genre);
    public Collection<Movie> listMoviesByReleaseDate(Date intervalBegin, Date intervalEnd);
    public Collection<Movie> listMoviesByTitle(String titleFragment);

    public Movie getMovieByTitle(String title) throws MovieNotFoundException;
    public Movie getMovieByReleaseDate(Date releaseDate) throws MovieNotFoundException;

    public void recordMovie(String title, Date releaseDate, int duration) throws ExistingTitleException;

    public void hireActorForMovie(Movie movie, Actor actor, String role);
    public void hireActorForMovie(Movie movie, Actor actor, String[] roles);

    public void setGenreForMovie(Movie movie, Genre genre);

}
