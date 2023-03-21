import java.util.ArrayList;

public class HashTable {
    private ListNode[] buckets;
    private int numOfBuckets; // MAXHASH
    private int size; // number of key value pairs in hash table

    public HashTable(){
        this(30);
    }
    public HashTable(int MAXHASH){
        this.numOfBuckets = MAXHASH;
        buckets = new ListNode[numOfBuckets];
        this.size=0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int StringHashFunction(String key){
        int p = 31; // dealing with lower caps only
        int m = 29; // numOfBuckets = 30 default

        int hashValue;

        if(numOfBuckets == 1000){
            m = 997; }
        if(numOfBuckets == 300){
            m = 293; }

        int hashSum = 0;

        char[] s = key.toCharArray();
        long p_power = 1;
        final int n = s.length;
        for (int i = 0; i < n; i++) {
            hashSum = (int)((hashSum + (s[i] - 'a' + 1) * p_power) % m);
            p_power = (p_power * p) % m;
        }
        hashValue = hashSum;
        return  hashValue;
    }
    public void insert (String key,Integer value){
        if(key == null ){
        throw new IllegalArgumentException("Key  is null");
        }
        int bucketIndex = StringHashFunction(key);
        ListNode head = buckets[bucketIndex];

        while (head!=null){
            if(head.key.equals(key)){
                head.value ++;
                return;
            }
            head= head.next;
        }
        size++;
        head = buckets[bucketIndex];
        ListNode node = new ListNode(key,value);
        node.next= head;
        buckets[bucketIndex]= node;
    }
    public int find(String key){
        int hashIndex = StringHashFunction(key);
        ListNode head = buckets[hashIndex];
        while(head!=null){
            if(head.key.equals(key)){
//                System.out.println("Value for key '"+key+"' = "+head.value);
                return head.value;
            }
            head=head.next;
        }
        System.out.println("Key not found '"+key+"'");
       return -1;
    }
    public void delete(String key){

        int hashIndex = StringHashFunction(key);
        ListNode head = buckets[hashIndex];
        ListNode prev = head;

        while(head != null){

            if(prev == head &&  (head.key.equals(key))){ //if head contains the key
                buckets[hashIndex] = head.next;
                System.out.println("Deleted key"+key);
                size--;
                return;
            }
            else if(prev != head && head.key.equals(key)){
                prev = head.next;
                System.out.println("Deleted key "+key);
                size--;
                return;
            }
            prev = head;
            head=head.next;
        }
        System.out.println("No key '"+key+"' found for Deletion.");
    }
    public void increase(String key) {
        // Increase the value of a key by 1
        int bucketIndex = StringHashFunction(key);
        ListNode node = buckets[bucketIndex];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value++;
                return;
            }
            node = node.next;
        }
    }

    public int findNumberOfCollionsUsingIndex(int index){
        int count =0;
        if(index>buckets.length){
            return -1;
        }
        ListNode cur = buckets[index];
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public ArrayList<String> list_all_keys() {
        // Return a list of all keys in the hash table
        ArrayList<String> keys = new ArrayList<String>();
//        System.out.println("List of all keys :");
        for (int i = 0; i < numOfBuckets; i++) {
            ListNode node = buckets[i];
            while (node != null) {
                keys.add(node.key);
                node = node.next;
            }
        }
        return keys;
    }
}