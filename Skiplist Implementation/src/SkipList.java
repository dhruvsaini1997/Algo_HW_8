import java.util.Random;

public class SkipList implements SkipListOperationsInterface {
    SkipListNode head;
    Random rand;

    public SkipList(){
        this.head = new SkipListNode(Integer.MIN_VALUE,0,null,null);
        this.rand = new Random();
    }

    private int getRandom(){
        int level =0;
        while(rand.nextDouble()<0.5 && level<=50)
            level++;
            return level;
    }
    public boolean insert(int num){

        if(searchKey(num)==true){
            return false;
        }
    int insertionLevel = getRandom();

    // if insertion level is greater than the head currenct level

    if(insertionLevel> head.level){
        head=new SkipListNode(null,insertionLevel,null,head);
    }

    SkipListNode cur = head,bottom = null;

    //iterate the base level to insert the value
        while(cur!=null){
            SkipListNode next = cur.next;
            //to check if the list end or if we get a value greater than the num to insert

            if(next == null || next.key > num){
                if(cur.level<= insertionLevel){
                    SkipListNode newNode = new SkipListNode(num, cur.level, next,null);
                    cur.next = newNode;
                    if(bottom!=null){
                        bottom.down= newNode;
                    }
                    bottom = newNode;
                }
                cur=cur.down;
            }else{
                cur=cur.next;
            }
        }
        return true;
    }

    public boolean searchKey(int key){
        SkipListNode cur = head;
        while(cur!=null){
            if(cur.key!=null && cur.key==key){
                return true;
            }
            SkipListNode next = cur.next;
            if(next == null || next.key>key){
                cur = cur.down;
            }else{
                cur = cur.next;
            }}
            return false;
    }

    public boolean lookup(int key){
        System.out.println("Searching key :"+ key);
        SkipListNode cur = head;
        while(cur!=null){
            System.out.print(cur.key);
            if(cur.key!=null && cur.key==key){
                System.out.println();
                return true;
            }
            SkipListNode next = cur.next;
            if(next == null || next.key>key){
                cur = cur.down;
                System.out.print("-> down ->");
            }else{
                cur = cur.next;
                System.out.print("-> right ->");
            }}
        return false;
    }

    public boolean delete(int key) {
        System.out.println("Deletion for key requested: "+key);
        boolean found =false;
        SkipListNode cur = head,prev=null;
        while(cur!=null){
            if(cur.key!=null && cur.key==key){
                found = true;
                break;
            } else if (cur.next==null || cur.next.key>key) {
                prev = cur;
                cur = cur.down;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(found!=true)
            return false;
        while(cur!=null){
            if(prev.next!=null && prev.next.key== cur.key){
                prev.next = cur.next;
            } else if (prev.next!=null && prev.next.key!=cur.key) {
                prev = prev.next;
                continue;
            }
            cur  = cur.down;
            prev = prev.down;
        }
        return true;
    }
    public void printSkipList(){
        System.out.println("Printing skipList Structure: ");
        SkipListNode curdown = head;

        while(curdown.down!=null){
            curdown=curdown.down;
        }
        curdown = curdown.next;

        SkipListNode top = head;

        while(curdown!=null){

            if(top.key == curdown.key){
                for(int i=0;i<=top.level;i++){
                    System.out.print(curdown.key+" ");
                }
                System.out.println();
                curdown=curdown.next;
                top = head;
            }

            else if (top.next==null || top.next.key> curdown.key){
                top=top.down;
            }
            else
//                if(top.next!=null && top.next.key<= curdown.key){
                top = top.next;
//            }
        }
    }
}
