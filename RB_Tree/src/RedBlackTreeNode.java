    public class RedBlackTreeNode {
        int value;
        RedBlackTreeNode left;
        RedBlackTreeNode right;
        RedBlackTreeNode parent;
        Color color;
        public RedBlackTreeNode(int value) {
            this.value=value;
            this.left=null;
            this.right=null;
            this.parent=null;
            this.color=Color.RED; // new node has to be red in color
        }

    }
