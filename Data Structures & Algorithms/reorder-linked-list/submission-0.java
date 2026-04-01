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
        ListNode next = null;
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev = null;
        slow.next = null;
        while(second != null){
            next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        ListNode curr = head;
        while(prev != null){
            ListNode currNext = curr.next;
            curr.next = prev;
            ListNode nextPrev = prev.next;
            prev.next = currNext;
            prev = nextPrev;
            curr = currNext;
        }
    }
}
