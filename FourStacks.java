
public class FourStacks extends MyQueue {
	
	public MyStack stack1 = new MyStack();
	public MyStack stack2 = new MyStack();
	public MyStack stack3 = new MyStack();
	public MyStack stack4 = new MyStack();
//	public int numElements1 = 0; 
//	public int numElements2 = 0;
//	public int numElements3 = 0;
//	public int numElements4 = 0;
	
	public FourStacks(int n) {
	stack1 = new MyStack(n/4);
	stack2 = new MyStack(n/4);
	stack3 = new MyStack(n/4);
	stack4 = new MyStack(n/4);
}
	public FourStacks() {
	stack1 = new MyStack();
	stack2 = new MyStack();
	stack3 = new MyStack();
	stack4 = new MyStack();
}
	public MyStack[] fs=new MyStack[4]; {
		fs[0]=stack1;
		fs[1]=stack2;
		fs[2]=stack3;
		fs[3]=stack4;}
	
	public void add(Job j) {
		if(0.0<=j.priority&&j.priority<=0.25) {
			stack1.add(j);
//			numElements1++; 
		}
		else if(0.25<j.priority&&j.priority<=0.5) {
			stack2.add(j);
//			numElements2++;
		}
		else if(0.5<j.priority&&j.priority<=0.75) {
			stack3.add(j);
//			numElements3++;
		}
		else if(0.75<j.priority&&j.priority<=1.0) {
			stack4.add(j);
//			numElements4++;
		}
	}
	public Job pop() {
		if (!(stack4.empty())) {
			return stack4.pop();
		}
		else {
			if(!(stack3.empty())) {
				
				return stack3.pop();
			}
			else {
				if(!(stack2.empty())) {
					return stack2.pop();
				}
				else {
					if (!(stack1.empty())) {
						return stack1.pop();
					}
					else {
						return null;
					}
				}
			}
		}
	}
	public boolean empty() {
		return (stack1.numElements == 0 && stack2.numElements == 0 && stack3.numElements == 0  
				&& stack4.numElements == 0) ; 
	}
}
