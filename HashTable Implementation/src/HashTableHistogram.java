
import java.util.ArrayList;
import java.util.Collections;

public class HashTableHistogram {
    public void showHistogram(HashTable table) {
        ArrayList<String> keys = table.list_all_keys();
        Collections.sort(keys); // sort the keys alphabetically
        int maxFrequency = 0;
        for (String key : keys) {
            int frequency = table.find(key);
            String bar = "";
            for (int i = 0; i < frequency; i++) {
                bar += "*";
            }
            System.out.printf("%-20s %s%n", key + ":", bar);
        }
    }
    public void printCollisions(HashTable hashTable, int maxHash){
        for(int i =0;i<maxHash;i++){
            int count = hashTable.findNumberOfCollionsUsingIndex(i);
            System.out.println("At Bucket index "+i+" number of collisions = "+count);
        }

    }

}
