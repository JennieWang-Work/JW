import java.util.*;
public class ExperiementQ {
	public static void main(String[] args) {
		double priority;
		Random generator = new Random(100000000);
//		System.out.println("What do you want to do?");
//		Scanner input = new Scanner(System.in);
//		String order="";
//		order = input.nextLine();
//		String[] orderList = order.split(" ");
        int n = Integer.parseInt(args[0]);
        int qIndex = Integer.parseInt(args[1]);
        int jobCount = 0;
		double totalDelay = 0.0;
		double p = 0.8;
		int time = 0;
		long startTime = System.currentTimeMillis();
		   String a;
		   switch (qIndex) {
		      case 1: MyStack ms = new MyStack(n);
			   for (time = 0; time < n; time++) {
				   if (generator.nextDouble() < p) {
					   a = "heads"; }
				   else a = "tails";
//			       flip a coin that comes up heads with probability p;
			       if (a=="heads") {
			           priority =generator.nextDouble();
			           jobCount++;
			           ms.add(new Job(priority, time));
			           }
			        else if (! ms.empty()) {
			          Job nextJob = ms.pop();
			          totalDelay +=
			            (time - nextJob.creationTime) * nextJob.priority;
			          }
			       	if(time==n/2) {p=0.2;}
			   }
			       	//switchfromstage1tostage2 } // end for loop
			    while (! ms.empty()) {    // stage 3
			          Job nextJob = ms.pop();
			          totalDelay +=
			            (time - nextJob.creationTime) * nextJob.priority;
			          time++ ;
			    }
			  System.out.println("Running time = " + ( System.currentTimeMillis() - startTime) +
			        " Quality = " + totalDelay/jobCount);
			  break;
		      case 2: FourStacks fs = new FourStacks(n);
		              
			   for (time = 0; time < n; time++) {
				   if (generator.nextDouble() < p) {
					   a = "heads"; }
				   else a = "tails";
//			       flip a coin that comes up heads with probability p;
			       if (a=="heads") {
			           priority =generator.nextDouble();
			           jobCount++;
			           fs.add(new Job(priority, time));
			           }
			        else if (! fs.empty()) {
			          Job nextJob = fs.pop();
			          totalDelay +=
			            (time - nextJob.creationTime) * nextJob.priority;
			          }
			       	if(time==n/2) {p=0.2;}
			   }
			       	//switchfromstage1tostage2 } // end for loop
			    while (! fs.empty()) {    // stage 3
			          Job nextJob = fs.pop();
			          totalDelay+=(time - nextJob.creationTime) * nextJob.priority;
			          time++ ;
			    }
			  System.out.println("Running time = " + ( System.currentTimeMillis() - startTime) +
			        " Quality = " + totalDelay/jobCount);
			  break;
		      case 3: MyLinkedList ml = new MyLinkedList();
			   for (time = 0; time < n; time++) {
				   if (generator.nextDouble() < p) {
					   a = "heads"; }
				   else a = "tails";
//			       flip a coin that comes up heads with probability p;
			       if (a=="heads") {
			           priority =generator.nextDouble();
			           jobCount++;
			           ml.add(new Job(priority, time));
			           }
			        else if (! ml.empty()) {
			          Job nextJob = ml.pop();
			          totalDelay +=
			            (time - nextJob.creationTime) * nextJob.priority;
			          }
			       	if(time==n/2) {p=0.2;}
			   }
			       	//switchfromstage1tostage2 } // end for loop
			    while (! ml.empty()) {    // stage 3
			          Job nextJob = ml.pop();
			          totalDelay +=
			            (time - nextJob.creationTime) * nextJob.priority;
			          time++ ;
			    }
			  System.out.println("Running time = " + ( System.currentTimeMillis() - startTime) +
			        " Quality = " + totalDelay/jobCount);
			  break;
		      case 4: MyHeap mh = new MyHeap(n);
			   for (time = 0; time < n; time++) {
				   if (generator.nextDouble() < p) {
					   a = "heads"; }
				   else a = "tails";
//			       flip a coin that comes up heads with probability p;
			       if (a=="heads") {
			           priority =generator.nextDouble();
			           jobCount++;
			           mh.add(new Job(priority, time));
			           }
			        else if (! mh.empty()) {
			          Job nextJob = mh.pop();
			          totalDelay +=
			            (time - nextJob.creationTime) * nextJob.priority;
			          }
			       	if(time==n/2) {p=0.2;}
			   }
			       	//switchfromstage1tostage2 } // end for loop
			    while (! mh.empty()) {    // stage 3
			          Job nextJob = mh.pop();
			          totalDelay +=
			            (time - nextJob.creationTime) * nextJob.priority;
			          time++ ;
			    }
			  System.out.println("Running time = " + ( System.currentTimeMillis() - startTime) +
			        " Quality = " + totalDelay/jobCount);
		     
		   	break;}
		  
	}
}

