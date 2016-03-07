package com.myer.dao;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.myer.connection.ConnectionManager;
import com.myer.constants.DB_INSTANCE;

import java.net.UnknownHostException;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class DAO {

    private static final String PROD_DB = "elevator-prod";

    private static final String TEST_DB = "elevator-test";

    private Gson gson = new Gson();

    public DBCollection getCollection(DB_INSTANCE dbInstance, String collectionName) throws UnknownHostException {
        ConnectionManager mgr = ConnectionManager.getInstance();
        Mongo mongo = mgr.getMongo(null);
        DB db;
        switch (dbInstance) {
            case TEST:
                db = mongo.getDB(TEST_DB);
                break;
            default:
                db = mongo.getDB(PROD_DB);
                break;
        }
        return db.getCollection(collectionName);
    }

    public Gson getGson() {
        return gson;
    }

}