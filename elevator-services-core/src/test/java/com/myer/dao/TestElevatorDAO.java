package com.myer.dao;

import com.mongodb.WriteResult;
import com.myer.beans.Elevator;
import com.myer.constants.DB_INSTANCE;
import junit.framework.TestCase;

import java.net.UnknownHostException;
import java.util.List;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class TestElevatorDAO extends TestCase {

    private ElevatorDAO dao;

    public void setUp() {
        dao = new ElevatorDAO();
        try {
            dao.getCollection(DB_INSTANCE.TEST, "elevators").drop();
        } catch (UnknownHostException e) {
            fail();
        }
    }

    public void testSave() {
        Elevator e = new Elevator();
        try {
            WriteResult wr = dao.insert(DB_INSTANCE.TEST, e);
            assertNotNull(wr);
        } catch (UnknownHostException e1) {
            fail();
        }
    }

    public void testRetrieve() {
        Elevator e = new Elevator();
        try {
            WriteResult wr = dao.insert(DB_INSTANCE.TEST, e);
            assertNotNull(wr);
            List<Elevator> elevators = dao.findElevators(DB_INSTANCE.TEST);
            assertEquals(1, elevators.size());
        } catch (UnknownHostException ex) {
            fail();
        }
    }

}