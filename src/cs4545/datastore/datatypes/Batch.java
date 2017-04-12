package cs4545.datastore.datatypes;

import java.security.Key;
import java.util.ArrayList;

/**
 * Created by DreamMachine on 4/5/2017.
 */
public class Batch
{
    ArrayList<KeyValue> batch = new ArrayList<>();

    public void add(KeyValue pair)
    {
        this.batch.add(pair);
    }

    public void add(ArrayList<KeyValue> pair)
    {
        this.batch.addAll(pair);
    }

    public ArrayList<KeyValue> getBatch()
    {
        return this.batch;
    }
}
