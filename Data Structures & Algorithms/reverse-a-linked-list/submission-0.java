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
        ListNode ans = new ListNode();
        ListNode temp = ans;
        ListNode nextOfReversed = new ListNode();
        while(head != null){
            int val = head.val;
            nextOfReversed.val = val;
            temp.next = nextOfReversed;
            nextOfReversed = new ListNode(0, nextOfReversed);
            head = head.next;
        }
        return nextOfReversed.next;
    }
}
