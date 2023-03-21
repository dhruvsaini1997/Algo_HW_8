import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeNode;

public class RedBlackTreeOperations implements IRedBlackTreeOperations{

    RedBlackTreeNode root;

    public void getRootNode(){
        System.out.println("Root Node is "+root.value);
    }
    public boolean isEmpty(){
        if(root==null){
            return true;
        }
        return false;
    }
    @Override
    public void insert( int val) {
        RedBlackTreeNode newNode = new RedBlackTreeNode(val);
        if(root==null){
            root = newNode;
            root.color= Color.BLACK;
            return;
        }
        RedBlackTreeNode parent = null; // just like prev pointer
        RedBlackTreeNode cur = root;

        while(cur!=null){
            parent = cur;
            if(cur.value>val){
                cur = cur.left;
            }else{
                cur=cur.right;
            }
        }
        // insertion spot
        newNode.parent = parent;
        if(val> parent.value){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }

        //once we have completely added the new TreeNode to the BST now we need to balance the tree using fixup
    insertionFixup(newNode);
    }
    private void leftRotate(RedBlackTreeNode x) {

        RedBlackTreeNode y = x.right;

        x.right = y.left;

        if (y.left != null) {  // check if y has a left subtree
            y.left.parent = x; // assign left subtree of y to x
        }

        y.parent = x.parent; // assign x's parent pointer to y's

        if (x.parent == null) {
            root = y; // just in case x was the root
        }
        else if (x == x.parent.left) { // if x was the left child of his parent
            x.parent.left = y;
        } else {
            x.parent.right = y; // if x was right child of his parent
        }
        y.left = x;  // assign x as y's left child
        x.parent = y; // mark x's parent pointer to y
    }
    private void rightRotate(RedBlackTreeNode x) {

        RedBlackTreeNode y = x.left;

        x.left = y.right;

        if (y.right != null) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        }
        else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }
    private void insertionFixup(RedBlackTreeNode node){
        while(node.parent!=null && node.parent.color==Color.RED){ // to check if the parent is black or not, if not continue
            if(node.parent== node.parent.parent.left) {// if the node's parent is left child
                RedBlackTreeNode uncle = node.parent.parent.right;
                if(uncle!=null && uncle.color == Color.RED){
                    // case 1 : when parent and uncle is red
                    // recolor to black
                    uncle.color = Color.BLACK;
                    node.parent.color = Color.BLACK;
                    // color grand parent red and make it the x
                        node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                }else{
                    if(node == node.parent.right){
                        // case 2 : parent is red and uncle is null or black and node is the right child
                        node = node.parent;
                        leftRotate(node);
                    }
                    // if node is the right child
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rightRotate(node.parent.parent);
                }
            }else{
                // if node's parent is right child

                RedBlackTreeNode uncle = node.parent.parent.left;
                if(uncle!=null && uncle.color == Color.RED){
                    // case 1 : when parent and uncle is red
                    // recolor to black
                    uncle.color = Color.BLACK;
                    node.parent.color = Color.BLACK;
                    // color grand parent red and make it the x
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                }else{
                    if(node == node.parent.left){
                        // case 2 : parent is red and uncle is null or black and node is the right child
                        node = node.parent;
                        rightRotate(node);
                    }
                    // if node is the right child
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    leftRotate(node.parent.parent);
            }}}
        root.color =Color.BLACK;
    }
    @Override
    public void max() {
        if(root==null){
            return;
        }
        RedBlackTreeNode cur = root;
        while(cur.right!=null){
            cur= cur.right;
        }
        System.out.println("Maximum value in the Tree :"+cur.value);
    }
    @Override
    public void min() {
        if(root==null){
            return;
        }
        RedBlackTreeNode cur = root;
        while(cur.left!=null){
            cur= cur.left;
        }
        System.out.println("Minimum value in the Tree :"+cur.value);
    }
    @Override
    public void searchValue(int val) {
        if (root==null){
            System.out.println("Tree is empty.");
            return;
        }
        RedBlackTreeNode curr = root;
        boolean keyFound = false;
        while(curr!= null ){
            if(curr.value==val){
                keyFound=true;
                break;
            }
            else if(curr.value>val ){
                curr = curr.left;
            }
            else if(curr.value<val ){
                curr = curr.right;
            }
        }
        if(keyFound && curr!=root){
            System.out.println("Key found with value :"+val);
            System.out.println("Parent is node with value "+curr.parent.value);
            if(curr.left!=null)
            System.out.println("Left Child value is "+ curr.left.value);
            if(curr.right!=null)
                System.out.println("Right Child value is "+ curr.right.value);
            if(curr.right==null && curr.left == null){
                System.out.println("This is a leaf Node.");
            }

        }
            else if(keyFound  && curr==root){
                System.out.println("key is the root node!");
        }
        else{
            System.out.println("No key found for value "+val);
        }
    }
    public void getSuccessor(int key){

        if (root==null){
            System.out.println("Tree is empty.");
            return ;
        }

        if(key==maxByNode(root).value){
            System.out.println("No Successor to "+key+", this is the maximum element in the tree");
            return;
        }

        RedBlackTreeNode curr = root;
        boolean keyFound = false;

        while(curr!= null ){
            if(curr.value==key){
                keyFound=true;
                break;
            }
            else if(curr.value>key ){
                curr = curr.left;
            }
            else if(curr.value<key ){
                curr = curr.right;
            }
        }
        if(!keyFound){
            System.out.println("No value found for :"+key);
            return ;
        }

        int succ = successor(curr).value;
        System.out.println("Value for successor of "+key+" :"+succ);
        return ;
    }
    public void getPredecessor(int key){

        if (root==null){
            System.out.println("Tree is empty.");
            return ;
        }
        if(key==minByNode(root).value){
            System.out.println("No Predecessor to "+key+", this is the minimum element in the tree");
            return;
        }

        RedBlackTreeNode curr = root;
        boolean keyFound = false;

        while(curr!= null ){
            if(curr.value==key){
                keyFound=true;
                break;
            }
            else if(curr.value>key ){
                curr = curr.left;
            }
            else if(curr.value<key ){
                curr = curr.right;
            }
        }
        if(!keyFound){
            System.out.println("No value found for :"+key);
            return;
        }
        System.out.println("Value for predecessor of "+key+" :"+predecessor(curr).value);
    }
    private RedBlackTreeNode successor(RedBlackTreeNode x) {
        if (x == null) {
            return null;
        }
        if (x.right != null) {
            return minByNode(x.right);
        } else {
            RedBlackTreeNode succ = null;
            RedBlackTreeNode curr = root;
            while (curr != null) {
                if (x.value < curr.value) {
                    // we found a node with a left child
                    succ = curr;
                    curr = curr.left;
                } else if (x.value > curr.value) {
                    // x is in the right subtree of curr
                    curr = curr.right;
                } else {
                    // we found the node x, but it has no right child
                    break;
                }
            }
            return succ;
        }

    }
    private RedBlackTreeNode predecessor(RedBlackTreeNode x) {
        if (x == null) {
            return null;
        }
        if (x.left != null) {
            return maxByNode(x.right);
        } else {
            RedBlackTreeNode pred = null;
            RedBlackTreeNode curr = root;
            while (curr != null) {
                if (x.value > curr.value) {
                    // we found a node with a left child
                    pred = curr;
                    curr = curr.right;
                } else if (x.value < curr.value) {
                    // x is in the right subtree of curr
                    curr = curr.left;
                } else {
                    // we found the node x, but it has no right child
                    break;
                }
            }
            return pred;
        }

    }
    private RedBlackTreeNode minByNode(RedBlackTreeNode node){
        if(node==null){
            return null;
        }
        RedBlackTreeNode cur = node;
        while(cur.left!=null){
            cur= cur.left;
        }
    return cur;
    }
    private RedBlackTreeNode maxByNode(RedBlackTreeNode node){
        if(node==null){
            return null;
        }
        RedBlackTreeNode cur = node;
        while(cur.right!=null){
            cur= cur.right;
        }
        return cur;
    }
    public void sort(){
        System.out.println("Inorder Sort for the tree : ");
        inorder(root);
    }
    private void inorder(RedBlackTreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
    @Override
    public void printRoot(){

        print2DUtil(root,10);
        System.out.print("Root for the tree is ");
        getRootNode();
        System.out.println("----------------------------------");
    }
    private void print2DUtil(RedBlackTreeNode node,int space)
    {

        int COUNT =5;
        if (node == null)
            return;

        // Inc dist btwn levels
        space += COUNT;

        // Process right child first
        print2DUtil(node.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        String c;
        if(node.color==Color.RED){
             c = "R";
        }else {
            c="B";
        }
        System.out.print(node.value+" "+c+"\n");

        // Process left child
        print2DUtil(node.left, space);
    }

    public void deleteBst(int value){
       deleteNode(root,value);
    }

    public void deleteNode(RedBlackTreeNode node, int key) {

        if (node == null)
            return ;  // base case: the tree is empty

        while(node!=null){
        // traverse the tree to find the node to be deleted
        if (key < node.value) {
            node = node.left;
        }
        else if (key > node.value) {
            node = node.right;
        }
        else {
            break;
        }
        }
        if(key == node.value){


            // case 1: node has no children
            if (node.left == null && node.right == null) {

                if(node == node.parent.left) // if node is left child of parent
                  node.parent.left = null;
                else{
                    node.parent.right = null;
                }
                node.parent=null; // break the node's parent relations
                return;
            }

            // case 2: node has one child
            else if (node.left == null) { // if no left child
                RedBlackTreeNode rightChild = node.right;

                rightChild.parent= node.parent; // break the node's parent relations

                if(node == node.parent.left) // if node is left child of parent
                    node.parent.left = rightChild;
                else{
                    node.parent.right = rightChild;
                }
                node.parent =null;
                node.right = null;
                return;

            } else if (node.right == null) {
                RedBlackTreeNode leftChild = node.left;

                leftChild.parent= node.parent; // break the node's parent relations

                if(node == node.parent.left) // if node is right child of parent
                    node.parent.left = leftChild;
                else{
                    node.parent.right = leftChild;
                }
                node.parent =null;
                node.left = null;
                return;
            }

            // case 3: node has two children
            else {
//
//                RedBlackTreeNode successor = successor(node.right);
//                node.value = ((RedBlackTreeNode) successor).value;
////                node.right = deleteNode(node.right, successor.value);


                RedBlackTreeNode succParent = node;

                RedBlackTreeNode succ = node.right;

                while (succ.left != null) {
                    succParent = succ;
                    succ = succ.left;
                }

                if (succParent != node)
                    succParent.left = succ.right;
                else
                    succParent.right = succ.right;

                // Copy Successor Data to root
                node.value = succ.value;


            return;}
        }else{
            System.out.println("No node with value :"+key+" found for deletion.");
    return;
        }

    }
}
