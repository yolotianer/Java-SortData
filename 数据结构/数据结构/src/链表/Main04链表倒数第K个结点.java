package 链表;

/**
 * @author yolo
 * @date 2020/3/12-20:12
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Main04链表倒数第K个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode last=head;
        int len=0;
        while(last!=null){
            len++;
            last=last.next;
        }
        if(len<k){
            return null;
        }
        ListNode front=head;
        ListNode low=head;
        for(int i=0;i<k;i++){
            low=low.next;
        }
        while(low!=null){
            front=front.next;
            low=low.next;
        }
        return front;
    }
}
