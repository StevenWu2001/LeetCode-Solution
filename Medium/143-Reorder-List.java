/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            dq.addFirst(temp);
            temp = temp.next;
        }
        
        ListNode newHead = dq.removeLast();
        temp = newHead;
        while (!dq.isEmpty()) {
            temp.next = dq.removeFirst();
            temp = temp.next;
            if (dq.isEmpty()) {
                break;
            }
            temp.next = dq.removeLast();
            temp = temp.next;
        }
        temp.next = null;
        
        head = newHead;
        
    }
}
