package com.myer.connection;

import com.mongodb.Mongo;
import junit.framework.TestCase;

import java.net.UnknownHostException;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class TestConnectionManager extends TestCase {

    public void testGetInstance() {
        ConnectionManager mgr = ConnectionManager.getInstance();
        assertNotNull(mgr);
    }

    public void testGetMongo() {
        Mongo mongo = null;
        try {
            mongo = ConnectionManager.getMongo(null);
        } catch (UnknownHostException e) {
            fail();
        }
        assertNotNull(mongo);
    }

}