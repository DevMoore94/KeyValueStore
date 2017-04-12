import cs4545.datastore.api.DatabaseManager;
import cs4545.datastore.datatypes.KeyValue;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by DreamMachine on 3/13/2017.
 */
public class DatabaseManagerTest
{
    public static void main(String[] args)
    {
        DatabaseManager dbManager = new DatabaseManager("db1");
        ArrayList<String> arr = new ArrayList<>();


        try
        {
            FileReader fileReader = new FileReader("data/words.txt");
            BufferedReader  reader = new BufferedReader(fileReader);

            String sCurrentLine;

            while ((sCurrentLine = reader.readLine()) != null) {
                arr.add(sCurrentLine);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {

            e.printStackTrace();

        }
        //Print dataset size
        System.out.println(arr.size());
        //Insertion time for dataset.
        long startTime = System.currentTimeMillis();
        for(int i=0; i <= arr.size()-1; i++)
        {
            dbManager.put(new KeyValue<Integer, String>(i,arr.get(i)));
        }


        long endTime = System.currentTimeMillis();


        dbManager.flush();

        System.out.println("Total Writing time: " + (endTime - startTime)/1000.00 + " Seconds");


        //Check fetch time
        startTime = System.currentTimeMillis();

        dbManager.get(Integer.toString(999));

        endTime = System.currentTimeMillis();

        System.out.println("Total fetch time: " + (endTime - startTime)/1000.00 + " Seconds");

        dbManager.close();
    }
}
