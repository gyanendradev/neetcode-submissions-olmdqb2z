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

class Solution {
    public Node copyRandomList(Node head) {
        Node ansList = new Node(0);
        HashMap<Node, Node> has = new HashMap<>();
        Node oldNode = head;
        Node newNode = ansList;
        while(oldNode != null){
            newNode.next = new Node(oldNode.val);
            newNode = newNode.next;
            has.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        oldNode = head;
        newNode = ansList.next;
        while(oldNode != null){
            Node randomNode = oldNode.random;
            newNode.random = has.get(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return ansList.next;
    }
}
