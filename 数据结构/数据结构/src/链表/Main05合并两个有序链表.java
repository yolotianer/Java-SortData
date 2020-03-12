package 链表;

/**
 * @author yolo
 * @date 2020/3/12-20:26
 */
public class Main05合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1==null){
            cur.next=l2;
        }
        if(l2==null){
            cur.next=l1;
        }
        return ans.next;
    }
}
