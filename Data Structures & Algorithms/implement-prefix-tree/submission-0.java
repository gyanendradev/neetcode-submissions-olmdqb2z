public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currNode = this.root;
        int i = 0;
        int n = word.length();
        while(i < n){
            Character ch = word.charAt(i);
            if(!currNode.children.containsKey(ch)){
                currNode.children.put(ch, new TrieNode());
            }
            currNode = currNode.children.get(ch);
            if(i == n-1){
                currNode.endOfWord = true;
            }
            i += 1;
        }
    }

    public boolean search(String word) {
        TrieNode currNode = this.root;
        int i = 0;
        int n = word.length();
        while(i < n){
            Character ch = word.charAt(i);
            if(!currNode.children.containsKey(ch)){
                return false;
            }
            currNode = currNode.children.get(ch);
            if(i == n-1){
                return currNode.endOfWord;
            }
            i += 1;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = this.root;
        int i = 0;
        int n = prefix.length();
        while(i < n){
            Character ch = prefix.charAt(i);
            if(!currNode.children.containsKey(ch)){
                return false;
            }
            currNode = currNode.children.get(ch);
            i += 1;
        }
        return true;
    }
}
