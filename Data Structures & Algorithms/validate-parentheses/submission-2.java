class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> closeToOpenMapping = new HashMap<>();
        closeToOpenMapping.put(']','[');
        closeToOpenMapping.put(')','(');
        closeToOpenMapping.put('}','{');
        ArrayList<Character> runningBraces = new ArrayList<>();
        for(int i =0; i< s.length(); i++){
            Character brace = s.charAt(i);
            if(!closeToOpenMapping.containsKey(brace)){
                runningBraces.add(brace);                
            }else{
                if(runningBraces.size() == 0){
                    return false;
                }
                Character lastBrace = runningBraces.remove(runningBraces.size() - 1);
                if(lastBrace != closeToOpenMapping.get(brace)){
                    return false;
                }
            }
        }
        if(runningBraces.size() > 0){
            return false;
        }
        return true;
    }
}
