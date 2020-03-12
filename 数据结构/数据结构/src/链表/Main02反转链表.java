package 链表;

/**
 * @author yolo
 * @date 2020/3/11-17:30
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Main02反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode ans=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=ans;
            ans=head;
            head=temp;
        }
        return ans;
    }
}
