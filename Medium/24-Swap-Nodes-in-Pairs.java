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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return head;
        }
        
        ListNode prev = null, curr = head, next = head.next;
        head = next;
        while (true) {
            ListNode temp = next.next;
            next.next = curr;
            curr.next = temp;
            if (prev != null) {
                prev.next = next;
            }
            prev = curr;
            curr = temp;
            if (curr == null || curr.next == null) {
                break;
            }
            next = curr.next;
        }
        return head;
    }
}
