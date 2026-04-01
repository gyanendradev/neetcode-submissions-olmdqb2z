class MinStack {

    ArrayList<Integer> list;
    int minVal;
    ArrayList<Integer> minStack;

    public MinStack() {
        list = new ArrayList<>();
        minVal = Integer.MAX_VALUE;
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        this.list.add(val);
        if(this.minStack.size() == 0){
            this.minStack.add(val);
        }else if(val < this.minStack.get(this.minStack.size() - 1)){
            this.minStack.add(val);
        }else{
            this.minStack.add(this.minStack.get(this.minStack.size() - 1));
        }
    }
    
    public void pop() {
        this.list.remove(this.list.size() - 1); 
        this.minStack.remove(this.minStack.size() - 1); 
    }
    
    public int top() {
        int val = this.list.get(this.list.size() - 1);
        return val;
    }
    
    public int getMin() {
        return this.minStack.get(this.minStack.size() - 1);
    }
}
