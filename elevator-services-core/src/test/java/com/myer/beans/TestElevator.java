package com.myer.beans;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class TestElevator extends TestCase {

    public Elevator e;

    public void setUp() {
        e = new Elevator();
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
        e.setStops(new int[]{1, 5, 6, 9});
        assertEquals(4, e.getStops().length);
        assertEquals(1, e.getStops()[0]);
        assertEquals(5, e.getStops()[1]);
        assertEquals(6, e.getStops()[2]);
        assertEquals(9, e.getStops()[3]);
    }

}