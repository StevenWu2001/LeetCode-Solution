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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> vals = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            vals.addLast(temp.val);
            temp = temp.next;
        }
        
        while (vals.size() > 1) {
            if (vals.getLast() == vals.getFirst()) {
                vals.removeFirst();
                vals.removeLast();
            } else {
                return false;
            }
        }
        
        return true;
    }
}
