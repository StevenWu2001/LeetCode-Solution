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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        ListNode temp = head;
        ListNode ans = new ListNode();
        while (temp != null) {
            l++;
            temp = temp.next;
        }
        
        if (l == 1) {
            return null;
        }
        
        
        int remove = l - n;
        
        if (remove == 0) {
            return head.next;
        }
        temp = head;
        
        
        for (int i = 0; i < l; i++) {
            if (i == remove - 1) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            
        }
        
        return head;
    }
}
