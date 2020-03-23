package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历：根-左-右
 * @author yolo
 * @date 2020/3/23-11:58
 */
public class PreOrder {
    /**
     * 递归
     * 二叉树前序遍历：根-左-右
     * @param root
     */
    public static void preOrder1(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
    }

    /**
     * 递归-有返回值
     * 二叉树前序遍历：根-左-右
     * @param root
     * @return
     */
    public static List<Integer>list=new ArrayList<>();
    public static List<Integer> preOrder2(Node root){
        if(root==null){
            return list;
        }
        list.add(root.val);
        preOrder2(root.left);
        preOrder2(root.right);
        return list;
    }

    /**
     * 二叉树前序遍历
     * 汇总思想：
     *      根+左子树+右子树
     *      整棵树的结果=汇总（左子树+右子树）
     * @param root
     * @return
     */
    public static List<Integer>preOrder3(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer>left=preOrder3(root.left);
        List<Integer>right=preOrder3(root.left);
        List<Integer>ans=new ArrayList<>();
        ans.add(root.val);
        ans.addAll(left);
        ans.addAll(right);
        return ans;
    }

}
