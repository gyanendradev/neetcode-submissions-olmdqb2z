class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        int m = t.length();
        int[] t_hashmap = new int[52];
        int[] s_hashmap = new int[52];
        String ans = "";
        for(int i=0; i < m; i++){
            char c = t.charAt(i);
            if (Character.isLowerCase(c)) {
                t_hashmap[c - 'a']++;
            } else {
                t_hashmap[c - 'A' + 26]++;
            }
        }
        while(right < m){
            char charAtRight = s.charAt(right);
            if (Character.isLowerCase(charAtRight)) {
                s_hashmap[charAtRight - 'a']++;
            } else {
                s_hashmap[charAtRight - 'A' + 26]++;
            }
            right += 1;
        }
        if(consistAllLetters(s_hashmap, t_hashmap)){
            ans = s.substring(left, right);
            return ans;
        }
        while(right < n){
            char c = s.charAt(right);
            if (Character.isLowerCase(c)) {
                s_hashmap[c - 'a']++;
            } else {
                s_hashmap[c - 'A' + 26]++;
            }
            if(consistAllLetters(s_hashmap, t_hashmap)){
                if(ans == ""){
                    ans = s.substring(left, right + 1);
                }else{
                    ans = right - left + 1 < ans.length() ? s.substring(left, right + 1) : ans;
                }
                while(right - left >= m){
                    char charAtLeft = s.charAt(left);
                    int index  = 0;
                    if (Character.isLowerCase(charAtLeft)) {
                        index = charAtLeft - 'a';
                    } else {
                        index =  charAtLeft - 'A' + 26;
                    }
                    if( t_hashmap[index] == 0 || t_hashmap[index] < s_hashmap[index]){
                        s_hashmap[index] -= 1;
                        left += 1;
                    }else{
                        break;
                    }
                }
                if(right-left < ans.length()){
                    ans = s.substring(left, right+1);
                }
            }
            right += 1;
        }
        return ans;
    }
    public boolean consistAllLetters(int[] current_has, int[] final_has){
        for(int i =0; i<52; i++){
            if(final_has[i] > current_has[i]){
                return false;
            }
        }
        return true;
    }
}
