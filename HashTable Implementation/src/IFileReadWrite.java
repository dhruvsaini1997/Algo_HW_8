public interface IFileReadWrite {
    public String readFile(String path);
    public String outputFile(String path,HashTable hashTable);
    public String outputCollisions(String path,HashTable hashTable,int maxHash);
}
