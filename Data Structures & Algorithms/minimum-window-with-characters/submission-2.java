class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] map1 = new int[52];
        String minimumSubString = "";
        for( int i =0; i < t.length(); i++){
            char c = t.charAt(i);
            if (Character.isLowerCase(c)) {
                map1[c - 'a']++;
            } else {
                map1[c - 'A' + 26]++;
            }
        }
        int left = 0;
        int[] map2 = new int[52];
        for( int right = 0 ; right < s.length(); right++){
            char c = s.charAt(right);
            if (Character.isLowerCase(c)) {
                map2[c - 'a']++;
            } else {
                map2[c - 'A' + 26]++;
            }
            Boolean isSubstring = true;
            for(int k = 0; k < map1.length; k++){
                if(map2[k] < map1[k]){
                    isSubstring = false;
                }
            }
            if(isSubstring){
                if(minimumSubString == ""){
                    minimumSubString = s.substring(left, right + 1);
                }
                while (left < s.length()) {
                    char newC = s.charAt(left);
                    int index = 0;
                    if (Character.isLowerCase(newC)) {
                        index = newC - 'a';
                    } else {
                        index = newC - 'A' + 26;
                    }
                    if (map1[index] == 0 || map2[index] > map1[index]) {
                        map2[index]--;
                        left++;
                    } else {
                        break;
                    }
                }
                if(right-left < minimumSubString.length()){
                    minimumSubString = s.substring(left, right+1);
                }
            }
        }
        return minimumSubString;
    }
}
