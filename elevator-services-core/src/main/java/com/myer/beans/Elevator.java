package com.myer.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class Elevator {

    private String id;

    private int people;

    private int floor;

    private String direction;

    private int iteration;

    private String session;

    private List<Integer> stops;

    public Elevator() {
        this.setStops(new ArrayList<Integer>());
        this.setFloor(1);
        this.setDirection("stationary");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public List<Integer> getStops() {
        return stops;
    }

    public void setStops(List<Integer> stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id='" + id + '\'' +
                ", people=" + people +
                ", floor=" + floor +
                ", direction='" + direction + '\'' +
                ", iteration=" + iteration +
                ", session='" + session + '\'' +
                ", stops=" + stops +
                '}';
    }

}