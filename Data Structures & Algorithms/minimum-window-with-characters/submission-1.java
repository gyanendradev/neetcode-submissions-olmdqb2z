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
        for( int i =0; i < s.length(); i++){
            int[] map2 = new int[52];
            for ( int j = i ; j< s.length(); j++){
                char c = s.charAt(j);
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
                        minimumSubString = s.substring(i,j+1);
                    }
                    if(j-i < minimumSubString.length()){
                        minimumSubString = s.substring(i, j+1);
                    }
                }
            }
        }
        return minimumSubString;
    }
}
