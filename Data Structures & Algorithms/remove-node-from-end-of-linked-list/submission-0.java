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
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length += 1;
            temp = temp.next;
        }
        int removeFromStart = length - n ;
        ListNode curr = head;
        if(removeFromStart == 0){
            return head.next;
        }
        while(removeFromStart > 0 ){
            removeFromStart -=1 ;
            if(removeFromStart == 0){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
}
