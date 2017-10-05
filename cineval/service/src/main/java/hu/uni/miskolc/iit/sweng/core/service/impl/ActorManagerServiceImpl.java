package hu.uni.miskolc.iit.sweng.core.service.impl;

import hu.uni.miskolc.iit.sweng.core.dao.ActorDAO;
import hu.uni.miskolc.iit.sweng.core.dao.exceptions.ActorAlreadyExsistsException;
import hu.uni.miskolc.iit.sweng.core.model.Actor;
import hu.uni.miskolc.iit.sweng.core.model.Nationality;
import hu.uni.miskolc.iit.sweng.core.service.ActorManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;



/**
 * Hello world!
 *
 */
public class ActorManagerServiceImpl implements ActorManagerService
{


    private static Logger LOG = LogManager.getLogger(ActorManagerServiceImpl.class);
    private ActorDAO actorDAO;

    public ActorManagerServiceImpl(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    public Collection<Actor> listAllActors() {
        LOG.info("List All Actors");
        return actorDAO.readActors();
    }

    public Collection<Actor> listActorsByNationality(Nationality nationality) {
        return actorDAO.readActorsByNationality(nationality);
    }

    public Collection<Actor> listAliveActor() {
        Collection<Actor> result = new HashSet<Actor>();
        for(Actor actor : actorDAO.readActors()){
            if(actor.isAlive()){
                result.add(actor);
            }
        }
        return result;
    }

    public void createActor(String firstName, String lastName, Date birthDate, Nationality nationality) {
        Actor actor = new Actor(firstName,lastName,birthDate,null, nationality);
        try {
            actorDAO.createActor(actor);
        } catch (ActorAlreadyExsistsException e) {
//            e.printStackTrace();
            LOG.warn(e.getMessage());
        }

    }

    public void reportActorDeath(String firstName, String lastName, Date deathDate) {

    }
}
