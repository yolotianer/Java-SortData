package 链表;

/**
 * @author yolo
 * @date 2020/3/11-15:45
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Main01移除链表元素 {
    /**
     * 新建一个链表存储结果
     * @param head
     * @param val
     * @return
     * 思路：遍历链表，讲val不等于给定值的节点存放于新的链表
     */
    public ListNode removeElements1(ListNode head, int val){
        if(head==null){
            return null;
        }
        ListNode ans=new ListNode(0);
        ListNode last=ans;
        while (head!=null){
            if(head.val==val){
                head=head.next;
            }else {
                ListNode temp=head.next;
                head.next=null;
                last.next=head;
                last=last.next;
                head=temp;
            }
        }
        return ans.next;
    }

    /**
     * 利用双指针，无需建立新的链表
     * @param head
     * @param val
     * @return
     * 思路：
     *  1.建立一个新的节点，对于删除头节点时方便我们操作
     *  2.定义两个指针：
     *      pre:要删除元素的前一个节点
     *      cur:当前节点
     *  3.如果cur.val==val,删除该节点
     *      pre.next=cur.next;
     *      cur=cur.next;
     *    否则：
     *      pre=cur;
     *      cur=cur.next;
     */
    public ListNode removeElements2(ListNode head, int val){
        ListNode ans=new ListNode(0);//避免头指针的元素是我们要删除的元素会到来的麻烦
        ans.next=head;
        ListNode pre=ans;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return ans.next;
    }
}
