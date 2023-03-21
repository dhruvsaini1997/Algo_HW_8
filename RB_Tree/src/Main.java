        import java.util.Scanner;

        public class Main {
                public static void main(String[] args) {

                    IRedBlackTreeOperations operations = new RedBlackTreeOperations();
                    operations.insert(10);
                    operations.insert(14);
                    operations.insert(81);
                    operations.insert(33);
                    operations.insert(98);
                    operations.insert(99);
                    operations.insert(31);
                    operations.insert(3);
                    operations.insert(100);
                    operations.insert(120);
                    operations.printRoot();
                    System.out.println("----------------------------------");

                    operations.deleteBst(14);
                    operations.printRoot();




//                  System.out.println("please list the operation you want to perform or else type 'end'");
//                    System.out.println("Operations can be 'insert', 'search','min','max', 'pre','suc','sort','printtree' ");
//            while(true) {
//                Scanner sc = new Scanner(System.in);
//                String useroperation = sc.nextLine();
//
//                if(useroperation.equals("end")){
//                        break;
//                }
//                else if (!useroperation.equals("insert") && operations.isEmpty()) {
//                    System.out.println("Please insert elements to tree to continue ");
//                }
//                else if (useroperation.equals("insert")) {
//                    int num;
//                    System.out.println("please insert the number of elements you want to insert to tree:");
//                    num = sc.nextInt();
//                    System.out.println("start entering numbers");
//                    while(num!=0){
//                        int insertKey = sc.nextInt();
//                        operations.insert(insertKey);
//                        num--;
//                    }
//                    System.out.println("Insertion Done");
//                }
//                else if (useroperation.equals("sort")) {
//                    operations.sort();
//                }
//                else if (useroperation.equals("printtree")) {
//                    operations.printRoot();
//                }
//                else if (useroperation.equals("min")) {
//                    operations.min();
//                }
//                else if (useroperation.equals("max")) {
//                    operations.max();
//                }
//                else if (useroperation.equals("pre")) {
//                    System.out.println("Enter number:");
//                    int num = sc.nextInt();
//                    operations.getPredecessor(num);
//                }
//                else if (useroperation.equals("suc")) {
//                    System.out.println("Enter number:");
//                    int num = sc.nextInt();
//                    operations.getSuccessor(num);
//                }
//
//                else if (useroperation.equals("search")) {
//                    System.out.println("Enter number:");
//                    int num = sc.nextInt();
//                    operations.searchValue(num);
//                }
//                else if (useroperation.equals("delete")){
//                    System.out.println("Enter number:");
//                    int num = sc.nextInt();
//                    operations.deleteBst(num);
//                }
//                else{
//                    System.out.println("please select a correct keyword operation.");
//                }
//            }
                     }
            }