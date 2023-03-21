public class SkipListNode {
    Integer key;
    Integer level;
    SkipListNode next,down;
    SkipListNode(Integer key,Integer level,SkipListNode n,SkipListNode d){
        this.key = key;
        this.down = d;
        this.next = n;
        this.level = level;
    }
}
