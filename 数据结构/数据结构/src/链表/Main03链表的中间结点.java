package 链表;

/**
 * 遍历链表，得到链表的长度，确定中间结点位置，再进行下一次遍历，找出中间结点
 * @author yolo
 * @date 2020/3/11-17:33
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 */
public class Main03链表的中间结点{
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode last=head;
        int len=0;
        while(last!=null){
            len++;
            last=last.next;
        }
        if(len==1){
            return head;
        }
        for(int mid=1;mid<=len/2;mid++){
            head=head.next;
        }
        return head;
    }

    public ListNode middleNode2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode low=head;
        ListNode fast=head;
        while (fast.next!=null){
            fast=fast.next.next;
            if(fast!=null){
                low=low.next;
            }
        }
        return low;
    }
}
