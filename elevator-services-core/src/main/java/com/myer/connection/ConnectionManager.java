package com.myer.connection;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class ConnectionManager {

    private final static String URL = "localhost:27017";

    private static ConnectionManager instance = null;

    private static Mongo mongo;

    protected ConnectionManager() {

    }

    public static ConnectionManager getInstance() {
        if(instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public static Mongo getMongo(String url) throws UnknownHostException {
        if(mongo == null) {
            mongo = new Mongo(url != null ? url : URL);
        }
        return mongo;
    }

}