//my approach
class CustomStack {
    int arr[];
    int size;
    int top;
    public CustomStack(int maxSize) {
        size= maxSize;
        arr= new int[size];
        top= size;
    }
    
    public void push(int x) {
        System.out.println(Arrays.toString(arr));
        if(top-1>=0){
            top--;
            arr[top]=x;
        }
    }
    
    public int pop() {
        if(top== size){
            return -1;
        }
        int ans= arr[top];
        arr[top]= -1;
        top++;
        return ans;
    }
    
    public void increment(int k, int val) {
        
        int start= size- k;
        for(int i=start >0 ? start: 0; i< size; i++){
            arr[i]+= val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

//optimised
class CustomStack {

    // Array to store stack elements
    private int[] stackArray;

    // Array to store increments for lazy propagation
    private int[] incrementArray;

    // Current top index of the stack
    private int topIndex;

    public CustomStack(int maxSize) {
        stackArray = new int[maxSize];
        incrementArray = new int[maxSize];
        topIndex = -1;
    }

    public void push(int x) {
        if (topIndex < stackArray.length - 1) {
            stackArray[++topIndex] = x;
        }
    }

    public int pop() {
        if (topIndex < 0) {
            return -1;
        }

        // Calculate the actual value with increment
        int result = stackArray[topIndex] + incrementArray[topIndex];

        // Propagate the increment to the element below
        if (topIndex > 0) {
            incrementArray[topIndex - 1] += incrementArray[topIndex];
        }

        // Reset the increment for this position
        incrementArray[topIndex] = 0;

        topIndex--;
        return result;
    }

    public void increment(int k, int val) {
        if (topIndex >= 0) {
            // Apply increment to the topmost element of the range
            int incrementIndex = Math.min(topIndex, k - 1);
            incrementArray[incrementIndex] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
