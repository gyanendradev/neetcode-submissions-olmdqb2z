class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        int[] counts = new int[26];
        for(char c : s.toCharArray()){
            counts[c-'a']+=1;
        }
        for(char c : t.toCharArray()){
            counts[c-'a']-=1;
        }
        for( int val : counts){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}
