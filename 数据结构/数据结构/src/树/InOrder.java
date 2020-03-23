package 树;

import org.omg.CORBA.INTERNAL;
import sun.reflect.annotation.AnnotationSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 二叉树中序遍历：左-根-右
 * @author yolo
 * @date 2020/3/23-11:58
 */
public class InOrder {
    /**
     * 左子树中序遍历+根+右子树中序遍历
     * @param root
     */
    public static void inOrder1(Node root){
        if(root==null){
            return;
        }
        inOrder1(root.left);
        System.out.println(root.val);
        inOrder1(root.right);
    }

    /**
     *
     * @param root
     * @return
     */
    public static List<Integer>ans=new ArrayList<>();
    public static List<Integer>inOrder2(Node root){
        if (root==null){
            return ans;
        }
        inOrder1(root.left);
        ans.add(root.val);
        inOrder1(root.right);
        return ans;
    }
    public static List<Integer>inOrder3(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer>left=inOrder3(root.left);
        List<Integer>right=inOrder3(root.right);
        List<Integer>result=new ArrayList<>();
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}
