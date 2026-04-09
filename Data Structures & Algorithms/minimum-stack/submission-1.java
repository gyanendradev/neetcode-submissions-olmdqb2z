class MinStack {

    ArrayList<Integer> stack;
    ArrayList<Integer> minValStack;

    public MinStack() {
        stack = new ArrayList<>();
        minValStack = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        if(this.minValStack.size() == 0){
            this.minValStack.add(val);
        }else if(val < this.minValStack.get(this.minValStack.size() - 1)){
            this.minValStack.add( val );
        }else{
            this.minValStack.add( this.minValStack.get(this.minValStack.size() - 1));
        }
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1 );
        this.minValStack.remove(this.minValStack.size() - 1 );
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        return this.minValStack.get(this.minValStack.size() - 1);
    }
}
