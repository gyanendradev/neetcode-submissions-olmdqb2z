class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put( ')', '(');
        closeToOpen.put('}','{');
        closeToOpen.put(']', '[');
        ArrayList<Character> stack = new ArrayList<>();
        for(int i =0 ; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(closeToOpen.containsKey(ch)){
                if(stack.size() == 0){
                    return false;
                }
                if(closeToOpen.get(ch) != stack.remove(stack.size()-1)){
                    return false;
                }
            }else{
                stack.add(ch);
            }
        }
        return stack.size()==0 ? true : false;
    }
}
