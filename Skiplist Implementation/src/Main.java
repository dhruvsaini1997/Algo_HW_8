public class Main {
    public static void main(String[] args) {
        SkipListOperationsInterface list = new SkipList();

        list.insert(10);
        list.insert(3);
        list.insert(11);
        list.insert(7);
        list.insert(31);
        list.insert(7);
//        list.lookup(31);
//        list.printSkipList();
//        System.out.println(list.delete(111));
        list.printSkipList();
        list.delete(10);
        list.printSkipList();
    }
}