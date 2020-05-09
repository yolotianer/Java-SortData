package 红黑树;

/**
 * @author yolo
 * @date 2020/4/29-12:11
 */
public class RedBlackTree {
    private final int R=0;
    private final int B=1;

    private Node root=null;//根节点

    class Node{
        int val;
        int color=R;
        Node left;
        Node right;
        Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(Node root,int val){//root不为null
        if(val>root.val){//右边插入
            if(root.right==null){
                root.right=new Node(val);//如果右孩子为null，直接插入
            }else {
                insert(root.right,val);//递归
            }
        }else {
            if(root.left==null){
                root.left=new Node(val);
            }else {
                insert (root.left,val);
            }
        }
    }

    public void leftRotate(Node node){

    }
}
