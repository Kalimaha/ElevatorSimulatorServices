package com.myer.connection;

import java.net.UnknownHostException;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class ConnectionManager {

    private final static String URL = "mongodb://myer:Ce09114238@ds023408.mlab.com:23408/elevator-test";

    private static ConnectionManager instance = null;

    private static Mongo mongo;

    protected ConnectionManager() {

    }

    public static ConnectionManager getInstance() {
        if(instance == null)
            instance = new ConnectionManager();
        return instance;
    }

    public static Mongo getMongo(String url) throws UnknownHostException {
        if(mongo == null)
            mongo = new Mongo(url != null ? url : URL);
        return mongo;
    }

}