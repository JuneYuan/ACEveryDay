/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p = dummy;
        // traverse linked list and stop upon such node that: node.next.val == node.next.next.val
        while (p != null) {
            if (p.next != null && p.next.next != null && p.next.val == p.next.next.val) {
                // record the value and loop deleting
                int dupVal = p.next.val;
                while (p.next != null && p.next.val == dupVal) {
                    p.next = p.next.next;
                    // p = p.next;
                }
            } else {
                p = p.next;
            }
        }
    
        return dummy.next;
    }
}
