package cs4545.datastore.core;

import cs4545.datastore.datatypes.KeyValue;

import java.util.Hashtable;


/**
 * Created by DreamMachine on 3/13/2017.
 */
public class Database
{
    private String databaseName;
    private HashIndex index;
    private DataReader reader;
    private DataWriter writer;
    static int nextOpenSlot = 0;



    public Database(String databaseName)
    {
        this.databaseName = databaseName;
        reader = new DataReader(databaseName);
        writer = new DataWriter(databaseName, this);
        this.index = HashIndex.getInstance();

        this.index.initIndex(reader.loadIndex());


    }



   public void put(KeyValue entry)
    {

        this.writer.write(entry);
        this.index.insertIndex(entry.getKey().toString(), nextOpenSlot);
        nextOpenSlot++;
    }

    public KeyValue get(String key)
    {
        int indexValue = this.index.getIndex(key);
        return this.reader.fetchRecord(indexValue);
    }

    public void flush()
    {
        this.writer.flush();
    }

    public void close()
    {
        this.writeIndexToDisk();
        this.reader.close();
    }

    public void writeIndexToDisk ()
    {
        this.writer.writeIndex();
    }

    public void displayContents()
    {

    }

    public HashIndex getIndex()
    {
        return this.index;
    }

}
