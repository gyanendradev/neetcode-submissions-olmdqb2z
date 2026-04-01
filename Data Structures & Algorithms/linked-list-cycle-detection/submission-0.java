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
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> has = new HashMap<>();
        while(head != null){
            if(has.containsKey(head)){
                return true;
            }else{
                has.put(head, 0);
            }
            head = head.next;
        }
        return false;
    }
}
