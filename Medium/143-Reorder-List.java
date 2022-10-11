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
    
    // Solution 1: Using Deque
    
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
    
    // Solution 2: Using Slow-Fast Pointer.
    
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null, curr = slow.next, next = curr.next;
        while (true) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr == null) {
                break;
            }
            next = next.next;
        }
        slow.next = null;
        
        ListNode p1 = head, p2 = prev, c1 = p1.next, c2 = p2.next;
        while (true) {
            p1.next = p2;
            p2.next = c1;
            p1 = c1;
            p2 = c2;
            if (c1 == null || c2 == null) {
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
    }
}
