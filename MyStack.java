
public class MyStack extends MyQueue {
	public Job[] stack;
    public int numElements = 0; // points to slot after top element

    public MyStack() {
    	stack = new Job[50];
    }
    public int max(int a, int b ) {
    	if(a<b) {
    		return b;
    	}
    	else return a;
    }
    public MyStack(int n) {
    	int a = max(50,n/2);
    	stack = new Job[a];
    }
    
  
   
    public Job pop() {
        numElements--;
        return stack[numElements];
     }

	public void add(Job j) {
		stack[numElements] = j;
        numElements++;
		
	}
	public boolean empty() {
		return numElements == 0; 
	}
}
