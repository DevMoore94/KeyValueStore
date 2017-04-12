package cs4545.datastore.core;

import cs4545.datastore.datatypes.Batch;
import cs4545.datastore.datatypes.KeyValue;

import java.io.*;

/**
 * Created by DreamMachine on 3/13/2017.
 */
public class DataWriter
{
    private ObjectOutputStream indexOutputStream;
    private BufferedWriter databaseWriter;
    private Database database;

    public DataWriter(String databaseName, Database database)
    {
        this.database = database;
        try
        {
            FileWriter databasefout = new FileWriter(databaseName + "//" + databaseName + "_records");
            FileOutputStream indexfout = new FileOutputStream(databaseName + "//" + databaseName + "_index");

            this.indexOutputStream = new ObjectOutputStream(indexfout);
            this.databaseWriter = new BufferedWriter(databasefout);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public void writeIndex()
    {
        try
        {
            indexOutputStream.writeObject(this.database.getIndex());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void bulkWrite(Batch batch)
    {
        for (KeyValue pair : batch.getBatch())
        {
            try
            {
                this.databaseWriter.write(pair.getKey() + " " + pair.getValue()+ "\n");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void write(KeyValue pair)
    {
        try
        {
            this.databaseWriter.write(pair.getKey() + " " + pair.getValue()+ "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void flush()
    {

        try
        {
            this.databaseWriter.flush();
            this.indexOutputStream.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            this.indexOutputStream.flush();
            this.databaseWriter.flush();
            this.indexOutputStream.close();
            this.databaseWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
