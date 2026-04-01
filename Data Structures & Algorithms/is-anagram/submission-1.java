class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> storeFirst = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            if(storeFirst.containsKey(s.charAt(i))){
                storeFirst.put(s.charAt(i), storeFirst.get(s.charAt(i))+1);
            }else{
                storeFirst.put(s.charAt(i), 1);
            }
        }

        for( int j =0; j<t.length();j++){
            if(!storeFirst.containsKey(t.charAt(j))){
                return false;
            }else if(storeFirst.get(t.charAt(j)) == 0){
                return false;
            }else{
                storeFirst.put(t.charAt(j), storeFirst.get(t.charAt(j))-1);
            }
        }
        for( Integer val : storeFirst.values()){
            if(val>0){
                return false;
            }
        }
        return true;
    }
}
