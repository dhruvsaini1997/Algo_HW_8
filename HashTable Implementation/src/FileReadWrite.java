    import java.io.*;
    import java.util.ArrayList;
    import java.util.Collections;

    public class FileReadWrite implements IFileReadWrite {
        public String readFile(String path) {
            String contents = null;
            try {
                File file = new File(path);
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                contents = sb.toString();
                reader.close();
                return contents;
            }
         catch(IOException e)
        {
            e.printStackTrace();
        }
            return contents;
        }



        public String outputFile(String path,HashTable hashTable) {
            try {
                FileWriter writer = new FileWriter(path);
                HashTable table = hashTable;

                ArrayList<String> keys = table.list_all_keys();
                Collections.sort(keys); // sort the keys alphabetically
                for (String key : keys) {
                    int frequency = table.find(key);
                    writer.write(key+" = "+frequency+"\n ");
                }
                writer.close();
                return  "Output File created: "+path;
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return "Error occured";
        }

        public String outputCollisions(String path,HashTable hashTable,int maxHash) {
            try {
                FileWriter writer = new FileWriter(path);
                HashTable table = hashTable;

                for(int i =0;i<maxHash;i++){
                    int count = hashTable.findNumberOfCollionsUsingIndex(i);
                    writer.write("At Bucket index "+i+" number of collisions = "+count+"\n");
                }

                writer.close();
                return  "Output File created: "+path;
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return "Error occured";
        }
    }
