
public class MyLinkedList extends MyQueue {
	 Node header; 
	 static class Node { 
	     Job value; 
	     Node next; 
	     double priority;
         Node() { 
	        next = null; 
	        } // Constructor 
	    } 
//	public Job value;
//	public MyLinkedList next;
//	public double priority;
	 public MyLinkedList() {
		header = new Node();
		header.next=null;
	}

	public boolean empty() {
		return header.next==null;
	}
	
	public void add(Job j) {
		if (empty()) {
			header.next=new Node();
			header.next.value=j;
		}
		else {
			Node n = header.next;
			Node n2= new Node();
			n2.value=j;
			n2.next=n;
			header.next=n2;
		}
	}
	public Job pop() {
		double largest=0.0;
		Node n=header;
		while(n.next!=null) {
			if(n.next.value.priority>largest) {
				largest=n.next.value.priority;
			}
			n=n.next;
		}
		n =header;
		while(n.next!=null) {
			if(n.next.value.priority==largest) {
				if(n.next.next==null) {
					Job a = n.next.value;
					n.next=null;
					return a;
				}
				else {
					Job a = n.next.value;
					n.next=n.next.next;
					return a;
				}
			}
			n=n.next;
		}
		return null;
	}
}
