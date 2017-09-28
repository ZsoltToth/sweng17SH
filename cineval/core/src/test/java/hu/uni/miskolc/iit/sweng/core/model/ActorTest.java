package hu.uni.miskolc.iit.sweng.core.model;


import org.junit.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static  org.junit.Assert.*;

/**
 * Created by tothzs on 2017.09.28..
 */
public class ActorTest {

    private Actor angelina;
    private Actor bud;

    @BeforeClass
    public static void beforeClass(){
//        System.out.println("before class - runs once");
    }

    @AfterClass
    public static  void afterClass(){
//        System.out.println("after class - runs once");
    }

    @Before
    public void setUp() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.angelina = new Actor(
                "Angelina",
                "Jollie",
                dateFormat.parse("1975-06-04"),
                null,
                Nationality.US);
        this.bud = new Actor(
                "Bud",
                "Spencer",
                dateFormat.parse("1929-10-31"),
                dateFormat.parse("2016-06-27"),
                Nationality.IT
        );
    }

    @After
    public void tearDown(){
//        System.out.println("tear down");
    }


    @Test
    public void testName(){
        assertEquals(angelina.getFirstName(), "Angelina");
    }

    @Test
    public void testIsActorAlive(){
        assertTrue(angelina.isAlive());
    }

    @Test
    public void testIsActorAliveIfDeceased(){
        assertFalse(bud.isAlive());
    }
}
