package 链表;

/**
 * @author yolo
 * @date 2020/3/12-20:48
 */
public class Main06链表分割 {
    public ListNode partition(ListNode pHead, int x) {
        ListNode cur1=new ListNode(0);
        ListNode cur2=new ListNode(0);
        ListNode small=cur1;
        ListNode big=cur2;
        while (pHead!=null){
            ListNode temp=pHead.next;
            pHead.next=null;
            if(pHead.val<x){
                cur1.next=pHead;
                cur1=cur1.next;
            }else {
                cur2.next=pHead;
                cur2=cur2.next;
            }
            pHead=temp;
        }
        cur1.next=big.next;
        return small.next;

    }
}
