

public class Job {

	public double priority;
	public int creationTime;
	public Job(double a, int b) {
		this.priority=a;
		this.creationTime=b;
	}
//	public void main (String[] args) {
//		System.out.println("What do you want to do?");
//		Scanner input = new Scanner(System.in);
//		String order="";
//		creationTime = 0;
//		
//		MyStack ms= new MyStack();
//		MyHeap mh = new MyHeap();
//		MyLinkedList ml = new MyLinkedList();
//		FourStacks fs = new FourStacks();
////		System.out.println("testing......");
//		while(creationTime<=50) {
//			order = input.nextLine();
//			//split
//			String[] orderList = order.split(" ");
//			name = "J"+orderList[0];
//			if(order.charAt(0)=='J') {
//			
//				priority = Double.parseDouble(orderList[1]);
//				Job j = new Job(priority,creationTime,name);
//				ms.add(j);
//				ml.add(j);
//				mh.add(j);
//				fs.add(j);
//				System.out.println("Creating job"+name+creationTime+
//						" priority"+ priority);
//				}
//			//if user asks to create an object
//			else if(order.charAt(0)=='E') {
//				Job j1 = ms.pop();
//				Job j2=ml.pop();
//				Job j3=mh.pop();
//				Job j4=fs.pop();
//				System.out.println("Stack: Executing"+j1.name+". Delay cost"+
//				(creationTime-j1.creationTime)*j1.priority);
//				System.out.println("Four stacks: Executing"+j4.name+". Delay cost"+
//						(creationTime-j4.creationTime)*j4.priority);
//				System.out.println("Linked list: Executing"+j2.name+". Delay cost"+
//						(creationTime-j2.creationTime)*j2.priority);
//				System.out.println("Heap: Executing"+j3.name+". Delay cost"+
//						(creationTime-j3.creationTime)*j3.priority);
//			}
//			creationTime++;
//		}
//	}
	
}
