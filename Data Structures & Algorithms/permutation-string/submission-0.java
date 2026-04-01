class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        for(int i =0; i < s1.length(); i++){
            map1[s1.charAt(i) - 'a']+=1;
        }
        for(int i =0; i < s2.length(); i++){
            int[] map2 = new int[26];
            for(int j = i ; j < s2.length(); j++){
                map2[s2.charAt(j) - 'a']+=1;
                boolean allEqual = true;
                for( int k =0; k< map1.length; k++){
                    if(map1[k] != map2[k]){
                        allEqual = false;
                    }
                }
                if(allEqual){
                    return true;
                }
            }
        }
        return false;
    }
}
