package cs4545.datastore.core;
import java.io.Serializable;
import java.util.Hashtable;


public class HashIndex implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Hashtable<String, Integer> indexTable = new Hashtable<>();
    private static HashIndex index = new HashIndex();


    private HashIndex(){}

    public static HashIndex getInstance()
    {
        return index;
    }

    public int getIndex(String key)
    {
        int value = indexTable.get(key);
        return value;
    }

    public void insertIndex(String key, int indexNum)
    {
        indexTable.put(key,indexNum);
    }

    public void initIndex(Hashtable<String, Integer> table)
    {
        indexTable = table;
    }


}
