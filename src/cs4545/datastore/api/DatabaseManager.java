package cs4545.datastore.api;

import cs4545.datastore.core.Database;
import cs4545.datastore.datatypes.KeyValue;

import java.io.File;

/**
 * Created by DreamMachine on 3/13/2017.
 */
public class DatabaseManager
{
    String databaseName;
    Database database;

    public DatabaseManager(String databaseName)
    {
        this.databaseName = databaseName;
        new File(databaseName).mkdir();

        database = new Database(databaseName);
    }

    public void put(KeyValue data)
    {
        this.database.put(data);
    }

    public KeyValue get(String key)
    {
        return this.database.get(key);
    }

    public void flush()
    {
        this.database.flush();
    }

    public void close()
    {

        this.database.close();
    }

    public void viewDatabaseContents()
    {
        this.database.displayContents();
    }




}
