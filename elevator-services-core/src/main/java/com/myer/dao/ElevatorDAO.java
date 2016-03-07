package com.myer.dao;

import com.mongodb.*;
import com.myer.beans.Elevator;
import com.myer.connection.ConnectionManager;
import com.mongodb.util.JSON;
import com.myer.constants.DB_INSTANCE;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
public class ElevatorDAO extends DAO {

    public WriteResult insert(DB_INSTANCE dbInstance, Elevator e) throws UnknownHostException {
        DBCollection dbCollection = getCollection(dbInstance, "elevators");
        BasicDBObject dbObj = (BasicDBObject)JSON.parse(this.getGson().toJson(e));
        return dbCollection.insert(dbObj);
    }

    public List<Elevator> findElevators(DB_INSTANCE dbInstance) throws UnknownHostException {
        List<Elevator> elevators = new ArrayList<>();
        DBCollection dbCollection = getCollection(dbInstance, "elevators");
        DBCursor cursor = dbCollection.find();
        while (cursor.hasNext()) {
            String next = cursor.next().toString();
            Elevator e = this.getGson().fromJson(next, Elevator.class);
            elevators.add(e);
        }
        return elevators;
    }

}