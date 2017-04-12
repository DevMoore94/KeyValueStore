package cs4545.datastore.datatypes;

import java.io.Serializable;

/**
 * Created by DreamMachine on 3/13/2017.
 */
public class KeyValue<K,V> implements Serializable
{
    private static final long serialVersionUID = 1L;

    private K key;
    private V value;

    public KeyValue(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public void setKey(K key)
    {
        this.key = key;
    }

    public V getValue()
    {
        return value;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

    public String toString()
    {
        return "Key: " + this.key + " Value: " + this.value;
    }

}
