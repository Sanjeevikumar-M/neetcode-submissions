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
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode dummy = slow.next;
        slow.next = null;

        ListNode prev = null;
        while(dummy!=null){
            ListNode next = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = next;
        }

        ListNode temp = head;
        dummy = prev;

        while(dummy!=null){
            ListNode cur = temp.next;
            ListNode nxt = dummy.next;

            temp.next = dummy;
            dummy.next = cur;

            temp = cur;
            dummy = nxt;
        }
    }
}
