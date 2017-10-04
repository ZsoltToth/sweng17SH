package hu.uni.miskolc.iit.sweng.core.model;

import java.util.*;

/**
 * Created by tothzs on 2017.09.28..
 */
public class Movie {

    private String title;
    private Date released;
    private int duration;
    private final Set<Genre> genre;
    private final Map<Actor,String[]> roles;

    public Movie(String title, Date released, int duration) {
        this.title = title;
        this.released = released;
        this.duration = duration;
        this.genre = new HashSet<Genre>();
        this.roles = new HashMap<Actor, String[]>();
    }

    public Movie(String title, Date released, int duration, Set<Genre> genre, Map<Actor, String[]> roles) {
        this.title = title;
        this.released = released;
        this.duration = duration;
        this.genre = genre;
        this.roles = roles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Genre> getGenre() {
        return genre;
    }

    public Map<Actor, String[]> getRoles() {
        return roles;
    }

    public boolean isInGenre(Genre genre){
        return this.genre.contains(genre);
    }

    public void addToGenre(Genre genre){
        this.genre.add(genre);
    }

    public boolean hasActorARole(Actor actor){
        return this.roles.keySet().contains(actor);
    }

    /**
     * Add a new role to the Actor in the movie.
     *
     * There are at least 2 bugs in this code (1 semantic, 1 performance). Have find them :)
     * @param actor
     * @param role
     */
    public void castActor(Actor actor, String role){
        if(!this.roles.containsKey(actor)){
            this.roles.put(actor, new String[] {role});
            return;
        }
        String[] rolesOfActor = this.roles.get(actor);
        String[] extendedRoles = new String[rolesOfActor.length+1];
        for(int i=0; i < rolesOfActor.length;i++){
            extendedRoles[i] = rolesOfActor[i];
        }
        extendedRoles[rolesOfActor.length] = role;
        this.roles.put(actor,extendedRoles);
    }
}
