package com.myer.dao;

import com.myer.constants.DB_INSTANCE;
import junit.framework.TestCase;

import java.net.UnknownHostException;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class TestElevatorDAO extends TestCase {

    public void testRetrieve() {
        ElevatorDAO dao = new ElevatorDAO();
        try {
            dao.findElevators(DB_INSTANCE.TEST);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}