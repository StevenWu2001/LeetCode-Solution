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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode prev = null, curr = head, next = head.next;
        while (true) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr == null) {
                break;
            }
            next = next.next;
            
        }
        
        return prev;
    }
}
