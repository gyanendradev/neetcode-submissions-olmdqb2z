public class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWordEnd = false;
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currNode = this.root;
        for(int i =0; i< word.length(); i++){
            if(!currNode.children.containsKey(word.charAt(i))){
                currNode.children.put(word.charAt(i), new TrieNode());
            }
            currNode = currNode.children.get(word.charAt(i));
        }
        currNode.isWordEnd = true;
    }

    public boolean search(String word) {
        return searchStartWithNode(word, this.root);
    }
    public boolean searchStartWithNode(String word, TrieNode currNode) {
        for(int i =0; i< word.length(); i++){
            if (word.charAt(i) == '.') {
                boolean isFound = false;
                for (Character key : currNode.children.keySet()) {
                    isFound = isFound || searchStartWithNode(word.substring(i+1, word.length()), currNode.children.get(key));
                }
                return isFound;
            }else{
                if(!currNode.children.containsKey(word.charAt(i))){
                    return false;
                }
                currNode = currNode.children.get(word.charAt(i));
            } 
        }
        return currNode.isWordEnd;
    }
}
