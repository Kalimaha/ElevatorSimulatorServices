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

    public void saveElevator(DB_INSTANCE dbInstance, Elevator e) throws UnknownHostException {
        DBCollection dbCollection = getCollection(dbInstance, "elevators");
        String json = this.getGson().toJson(e);
        System.out.println(json);
    }

    public List<Elevator> findElevators(DB_INSTANCE dbInstance) throws UnknownHostException {
        List<Elevator> elevators = new ArrayList<>();
        ConnectionManager mgr = ConnectionManager.getInstance();
        DBCollection dbCollection = getCollection(dbInstance, "elevators");
        DBCursor cursor = dbCollection.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next().toString());
        }
        return elevators;
    }

}