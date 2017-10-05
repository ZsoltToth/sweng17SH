package hu.uni.miskolc.iit.sweng.core.dao;

import hu.uni.miskolc.iit.sweng.core.dao.exceptions.ActorAlreadyExsistsException;
import hu.uni.miskolc.iit.sweng.core.dao.exceptions.ActorNotFoundException;
import hu.uni.miskolc.iit.sweng.core.model.Actor;
import hu.uni.miskolc.iit.sweng.core.model.Nationality;

import java.util.Collection;

/**
 * Created by tothzs on 2017.10.05..
 *
 * Data Access Object for the Actor class.
 *
 * It contains the CRUD methods that are:
 *  Create
 *  Read
 *  Update
 *  Delete
 */
public interface ActorDAO {

    void createActor(Actor actor) throws ActorAlreadyExsistsException;


    Collection<Actor> readActors();
    Collection<Actor> readActorsByName(String name);
    Collection<Actor> readActorsByNationality(Nationality nationality);

    void updateActor(Actor actor) throws ActorNotFoundException;

    void deleteActor(Actor actor) throws ActorNotFoundException;

}
