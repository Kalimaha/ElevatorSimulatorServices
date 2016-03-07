package com.myer.beans;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class TestElevator extends TestCase {

    private Elevator e;

    public void setUp() {
        e = new Elevator();
    }

    public void testDefaultValues() {
        assertNotNull(e.getStops());
        assertEquals(e.getFloor(), 1);
        assertEquals(e.getDirection(), "stationary");
    }

    public void testId() {
        e.setId("A");
        assertEquals("A", e.getId());
    }

    public void testPeople() {
        e.setPeople(5);
        assertEquals(5, e.getPeople());
    }

    public void testFloor() {
        e.setFloor(1);
        assertEquals(1, e.getFloor());
    }

    public void testDirection() {
        e.setDirection("up");
        assertEquals("up", e.getDirection());
    }

    public void testIteration() {
        e.setIteration(10);
        assertEquals(10, e.getIteration());
    }

    public void testSession() {
        e.setSession("alpha");
        assertEquals("alpha", e.getSession());
    }

    public void testStops() {
        List<Integer> stops = new ArrayList<>();
        stops.add(1);
        stops.add(5);
        stops.add(6);
        stops.add(9);
        e.setStops(stops);
        assertEquals(4, e.getStops().size());
        assertEquals(1, e.getStops().get(0).intValue());
        assertEquals(5, e.getStops().get(1).intValue());
        assertEquals(6, e.getStops().get(2).intValue());
        assertEquals(9, e.getStops().get(3).intValue());
    }

}