package hu.uni.miskolc.iit.sweng.core.service;

import hu.uni.miskolc.iit.sweng.core.model.Actor;
import hu.uni.miskolc.iit.sweng.core.model.Nationality;

import java.util.Collection;
import java.util.Date;

/**
 * Created by tothzs on 2017.09.28..
 */
public interface ActorManagerService {

    public Collection<Actor> listAllActors();
    public Collection<Actor> listActorsByNationality(Nationality nationality);
    public Collection<Actor> listAliveActor();



    public void createActor(String firstName, String lastName, Date birthDate, Nationality nationality);
    public void reportActorDeath(String firstName, String lastName, Date deathDate);
}
