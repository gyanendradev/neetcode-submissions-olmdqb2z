class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        for(int i =0; i < s1.length(); i++){
            map1[s1.charAt(i) - 'a']+=1;
        }
        int left = 0;
        int[] map2 = new int[26];
        for(int i =0; i < s1.length() - 1; i++){
            map2[s2.charAt(i) - 'a'] += 1;
        }
        for(int right = s1.length() - 1 ; right < s2.length(); right++){
            map2[s2.charAt(right) - 'a'] += 1;
            Boolean allEqual = true;
            for( int k =0; k< map1.length; k++){
                if(map1[k] != map2[k]){
                    allEqual = false;
                }
            }
            if(allEqual){
                return true;
            }
            map2[s2.charAt(left) - 'a'] -= 1;
            left += 1;
        }
        return false;
    }
}
