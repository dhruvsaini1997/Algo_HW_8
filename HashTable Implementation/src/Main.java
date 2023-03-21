public class Main {
    public static void main(String[] args) {
        int MAXHASH=30;

        String inputFilePath="C:/Users/user/Desktop/Algorithms/Hwrk8/alice_in_wonderland.txt";
        String outputFilePath="C:/Users/user/Desktop/Algorithms/Hwrk8/alice_in_wonderland_output.txt";
        String collisionFilePath="C:/Users/user/Desktop/Algorithms/Hwrk8/alice_in_wonderland_output";


        HashTable table = new HashTable(MAXHASH);
        IFileReadWrite fileReadWrite = new FileReadWrite();
        HashTableHistogram tableHistogram = new HashTableHistogram();

        String contents = fileReadWrite.readFile(inputFilePath);

        String[] processed_contents = contents.toLowerCase().split("\\W+");
        for (int i = 0; i< processed_contents.length; i++){
            table.insert(processed_contents[i],1);
        }


        String response = fileReadWrite.outputFile(outputFilePath,table);
        String collisionReport = fileReadWrite.outputCollisions(collisionFilePath+MAXHASH+".txt",table,MAXHASH);


        table.find("in");
        table.find("wonderland");
        table.find("dhruv");
        table.delete("prizes");
        table.delete("Dhruv");
        tableHistogram.printCollisions(table,MAXHASH);

    }

}
