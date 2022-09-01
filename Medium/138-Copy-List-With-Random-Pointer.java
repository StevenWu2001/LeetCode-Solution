/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> nodeIdx = new HashMap<>();
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            nodeIdx.put(temp, idx);
            idx++;
            temp = temp.next;
        }
        
        Node copy = new Node(head.val);
        Node tempCopy = copy;
        temp = head.next;
        
        while (temp != null) {
            tempCopy.next = new Node(temp.val);
            temp = temp.next;
            tempCopy = tempCopy.next;
        }
        
        tempCopy = copy;
        temp = head;
        idx = 0;
        
        while (temp != null) {
            if (nodeIdx.get(temp.random) != null) {
                int diff = nodeIdx.get(temp.random) - idx;
                Node tempRandom;
                if (diff > 0) {
                    tempRandom = tempCopy;
                    for (int i = 0; i < diff; i++) {
                        tempRandom = tempRandom.next;
                    }
                    
                } else {
                    tempRandom = copy;
                    for (int i = 0; i < idx + diff; i++) {
                        tempRandom = tempRandom.next;
                    }   
                }
                tempCopy.random = tempRandom;
            }
            

            tempCopy = tempCopy.next;
            temp = temp.next;
            idx++;
        }
        
        return copy;  
    }
}
