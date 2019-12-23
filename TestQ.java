import java.util.Scanner;

public class TestQ {

	public static void main (String[] args) {
		System.out.println("What do you want to do?");
		Scanner input = new Scanner(System.in);
		String order="";
	    int creationTime = 0;
	    int totalJob=0;
	    double StackQuality=0.0;
	    double HeapQuality=0.0;
	    double LinkedListQuality=0.0;
	    double FourStacksQuality=0.0;
		MyStack ms= new MyStack();
		MyHeap mh = new MyHeap();
		MyLinkedList ml = new MyLinkedList();
		FourStacks fs = new FourStacks();
		while(creationTime<=50) {
			System.out.println("CreationTime: "+creationTime);
			order = input.nextLine();
			//split
			String[] orderList = order.split(" ");
			String name = "J"+orderList[0];
			if(order.charAt(0)=='J') {
				double priority = Double.parseDouble(orderList[1]);
				Job j = new Job(priority,creationTime);
				ms.add(j);
				ml.add(j);
				mh.add(j);
				fs.add(j);
				totalJob+=1;
				System.out.println("Creating job J"+""+creationTime+
						" priority "+ priority);
				}
			//if user asks to create an object
			else if(order.charAt(0)=='E') {
				Job j1 = ms.pop();
				Job j2=ml.pop();
				Job j3=mh.pop();
				Job j4=fs.pop();
				StackQuality+=(creationTime-j1.creationTime)*j1.priority;
				HeapQuality+=(creationTime-j3.creationTime)*j3.priority;
			    LinkedListQuality+=(creationTime-j2.creationTime)*j2.priority;
				FourStacksQuality+=(creationTime-j4.creationTime)*j4.priority;
				System.out.println("Stack: Executing J"+""+j1.creationTime+". Delay cost "+
						String.format("%.2f",(creationTime-j1.creationTime)*j1.priority).toString());
				System.out.println("Four stacks: Executing J"+""+j4.creationTime+". Delay cost "+
						String.format("%.2f", (creationTime-j4.creationTime)*j4.priority).toString());
				System.out.println("Linked list: Executing J"+""+j2.creationTime+". Delay cost "+
						String.format("%.2f",(creationTime-j2.creationTime)*j2.priority).toString());
				System.out.println("Heap: Executing J"+""+j3.creationTime+". Delay cost "+
						String.format("%.2f",(creationTime-j3.creationTime)*j3.priority).toString());
			}
//			creationTime++;
			else if(order.charAt(0)=='F') {
				while((!ms.empty())&&(!ml.empty())&&(!fs.empty())&&(!mh.empty())) {
					Job j1 = ms.pop();
					Job j2=ml.pop();
					Job j3=mh.pop();
					Job j4=fs.pop();
					StackQuality+=(creationTime-j1.creationTime)*j1.priority;
					HeapQuality+=(creationTime-j3.creationTime)*j3.priority;
				    LinkedListQuality+=(creationTime-j2.creationTime)*j2.priority;
					FourStacksQuality+=(creationTime-j4.creationTime)*j4.priority;
					System.out.println("Stack: Executing J"+""+j1.creationTime+". Delay cost "+
							String.format("%.2f",(creationTime-j1.creationTime)*j1.priority).toString());
					System.out.println("Four stacks: Executing J"+""+j4.creationTime+". Delay cost "+
							String.format("%.2f", (creationTime-j4.creationTime)*j4.priority).toString());
					System.out.println("Linked list: Executing J"+""+j2.creationTime+". Delay cost "+
							String.format("%.2f",(creationTime-j2.creationTime)*j2.priority).toString());
					System.out.println("Heap: Executing J"+""+j3.creationTime+". Delay cost "+
							String.format("%.2f",(creationTime-j3.creationTime)*j3.priority).toString());
				if(ms.empty()||ml.empty()||fs.empty()||mh.empty()){
					System.out.println("Quality: Stack: "+String.format("%.3f",StackQuality/totalJob).toString()
					 +"  Heap: " +String.format("%.3f",HeapQuality/totalJob).toString() 
					 +"  LinkedList: " +String.format("%.3f",LinkedListQuality/totalJob).toString()
					 +"	 FourStack: " +String.format("%.3f",FourStacksQuality/totalJob).toString()
					);
					break;
				}
					creationTime++;
					System.out.println("CreationTime: "+creationTime);
				}
				break;
			}
			creationTime++;
			
		}
		
	}
}
