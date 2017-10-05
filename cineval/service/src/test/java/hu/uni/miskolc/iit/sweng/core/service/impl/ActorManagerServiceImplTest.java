package hu.uni.miskolc.iit.sweng.core.service.impl;


import hu.uni.miskolc.iit.sweng.core.dao.ActorDAO;
import hu.uni.miskolc.iit.sweng.core.dao.exceptions.ActorAlreadyExsistsException;
import hu.uni.miskolc.iit.sweng.core.model.Actor;
import hu.uni.miskolc.iit.sweng.core.model.Nationality;
import hu.uni.miskolc.iit.sweng.core.service.ActorManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import static org.testng.CommandLineArgs.LOG;

/**
 * Unit test for simple App.
 */
public class ActorManagerServiceImplTest{


    private ActorManagerService service;

    @Before
    public void  setUp() throws ParseException, ActorAlreadyExsistsException {
        ActorDAO actorDAO = EasyMock.createMock(ActorDAO.class);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Actor angelina = new Actor(
                "Angelina",
                "Jollie",
                dateFormat.parse("1975-06-04"),
                null,
                Nationality.US);
        Actor bud = new Actor(
                "Bud",
                "Spencer",
                dateFormat.parse("1929-10-31"),
                dateFormat.parse("2016-06-27"),
                Nationality.IT
        );
        Actor charlie = new Actor(
                "Charlie",
                "Sheen",
                dateFormat.parse("1975-06-04"),
                null,
                Nationality.US);
        EasyMock.expect(actorDAO.readActors()).andReturn(Arrays.asList(angelina,bud));
        actorDAO.createActor(angelina);
        EasyMock.expectLastCall().andThrow(new ActorAlreadyExsistsException("Angleina Jolie already exists!"));
        actorDAO.createActor(charlie);
        EasyMock.replay(actorDAO);
        service = new ActorManagerServiceImpl(actorDAO);
    }

    @Ignore
    @Test
    public void testLogging(){
        Logger LOG = LogManager.getLogger(ActorManagerServiceImpl.class);
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void testListAllActors() throws ParseException {
//        Logger LOG = LogManager.getLogger(ActorManagerServiceImpl.class);
//        LOG.info(service.listAllActors());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Actor angelina = new Actor(
                "Angelina",
                "Jollie",
                dateFormat.parse("1975-06-04"),
                null,
                Nationality.US);
        Actor bud = new Actor(
                "Bud",
                "Spencer",
                dateFormat.parse("1929-10-31"),
                dateFormat.parse("2016-06-27"),
                Nationality.IT
        );
        Collection<Actor> expected = Arrays.asList(angelina,bud);
        Collection<Actor> actual = service.listAllActors();

        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void createActorWhichExists() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        service.createActor("Angelina","Jollie",dateFormat.parse("1975-06-04"),Nationality.US);
    }


    @Test
    public void createNewActor() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        service.createActor("Charlie","Sheen",dateFormat.parse("1975-06-04"),Nationality.US);
    }
}
