package com.myer.dao;

import com.mongodb.DBCollection;
import com.myer.constants.DB_INSTANCE;
import junit.framework.TestCase;

import java.net.UnknownHostException;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class TestDAO extends TestCase {

    public void testGetCollection() {
        DAO dao = new DAO();
        DBCollection c = null;
        try {
            c = dao.getCollection(DB_INSTANCE.TEST, "elevators");
            assertEquals("elevator-test", c.getDB().getName());
        } catch (UnknownHostException e) {
            fail();
        }
        try {
            c = dao.getCollection(DB_INSTANCE.PROD, "elevators");
            assertEquals("elevator-prod", c.getDB().getName());
        } catch (UnknownHostException e) {
            fail();
        }
    }
}
