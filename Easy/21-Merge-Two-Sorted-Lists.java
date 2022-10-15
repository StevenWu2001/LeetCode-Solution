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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode ans = new ListNode();
        ListNode temp = ans;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.val = l1.val;
                l1 = l1.next;
                if (l1 == null) {
                    break;
                }
            } else {
                temp.val = l2.val;
                l2 = l2.next;
                if (l2 == null) {
                    break;
                }
            }
            
            temp.next = new ListNode();
            temp = temp.next;
        }
        
        while (l1 != null) {
            temp.next = new ListNode();
            temp = temp.next; 
            temp.val = l1.val;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            temp.next = new ListNode();
            temp = temp.next; 
            temp.val = l2.val;
            l2 = l2.next;           
        }
        
        return ans;
    }
}
