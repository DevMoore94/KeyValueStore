package cs4545.datastore.core;

import cs4545.datastore.datatypes.KeyValue;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Hashtable;

/**
 * Created by DreamMachine on 3/13/2017.
 */
public class DataReader
{
    //BufferedReader bufferedReader;
    ObjectInputStream inputStream;
    String databaseName;




    public DataReader(String databaseName)
    {
        FileReader fileReader;
        FileInputStream fileInputStream;
        this.databaseName = databaseName;

        File indexFile = new File(databaseName + "//" + databaseName + "_index");
        File databaseFile = new File(databaseName + "//" + databaseName + "_records");
        try
        {


            if(databaseFile.exists())
            {
                fileReader = new FileReader(databaseFile);
                fileInputStream = new FileInputStream(indexFile);


            }
            else
            {
                databaseFile.createNewFile();
                indexFile.createNewFile();
                fileReader = new FileReader(databaseFile);
                fileInputStream = new FileInputStream(indexFile);

            }


            //this.bufferedReader = new BufferedReader(fileReader);
            this.inputStream = new ObjectInputStream(fileInputStream);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public Hashtable<String,Integer> loadIndex()
    {
        Hashtable<String,Integer> index = new Hashtable<>();
        try
        {
            index = (Hashtable<String,Integer>) inputStream.readObject();
        }
        catch (EOFException e)
        {
           System.out.println("Loading Finished");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return index;
    }

    public KeyValue fetchRecord(int index)
    {
        String[] arr = null;
        File databaseFile = new File(databaseName + "//" + databaseName + "_records");
        try
        {

            arr = FileUtils.readLines(databaseFile, "UTF-8").get(index).split(" ");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new KeyValue(arr[0], arr[1]);
    }

    public void close()
    {
        try
        {
            this.inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
