package hu.uni.miskolc.iit.sweng.core.model;

import java.util.Date;

/**
 * Created by tothzs on 2017.09.28..
 */
public class Actor {

    private final String firstName;
    private final String lastName;
    private final Date birthDate;
    private Date deathDate;
    private Nationality nationality;

    public Actor(String firstName, String lastName, Date birthDate, Date deathDate, Nationality nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}

