
public class MyHeap extends MyQueue{
	public Job[] Heap; 
	public int size=0; 
	public int parent(int pos) { 
        return pos / 2; 
    } 

    public MyHeap() {
    	Heap = new Job[50];
    }
    
    public MyHeap(int n) {
    	int a = max(50,n/2);
    	Heap= new Job[a];
    }
    public int max(int a, int b ) {
    	if(a<b) {
    		return b;
    	}
    	else return a;
    }
    private void swap(int fpos, int spos) { 
        Job tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
    
	public void add(Job element) { 
		Heap[size++] = element; 
	    int current = size-1;
	    while (current<size && Heap[current].priority < Heap[parent(current)].priority) { 
	    	
	    	swap(current, parent(current)); 
	    	
	    	if(Heap[current].priority < Heap[current-1].priority) {
	    		swap(current, current-1);
	    	}
	    	current = parent(current);
	    } 
	}
	public boolean empty(){
		return size==0;
	}
	public Job pop() {
		size--;
		return Heap[size];
	}

}
