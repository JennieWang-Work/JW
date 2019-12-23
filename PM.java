//RongxianWang's first programming assignment
//rw2364
import java.util.*;
public class PM {
	public static int maxPeople = 100;
    public static Person allPeople[] = new Person[maxPeople];
    public static int peopleCount = 0 ;
    public static Person findPerson(String name) {
    	for(int i=0;i<peopleCount;i++) {
    		if(name.equals(allPeople[i].getName())){
    			return allPeople[i];
    		}
    	}
    return null;	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("What do you want to do?");
		Scanner input = new Scanner(System.in);
		String order="";
		boolean notDone=true;
		while(notDone) {
			order = input.nextLine();
			//split
			String[] orderList = order.split(" ");
			if(order.charAt(0)=='X') {
				notDone=false;
			}
			//if user asks to create an object
			else if(order.charAt(0)=='O') {
				Person a = findPerson(orderList[1]);
				//if the name has already been assigned
				//or peopleCount equals maxPeople
				if(( a != null) || peopleCount == maxPeople) {
					System.out.println("Error!");
					break;
				}
				//create person
				Person P = new Person(orderList[1]);
				peopleCount += 1;
				allPeople[peopleCount-1] = P;	
				
			}
			//if user wants to set parent
			else if(order.charAt(0)=='P') {
				Person a = findPerson(orderList[1]);
				Person b = findPerson(orderList[2]);
				//if no such person exists
				//print warning
				if( a==null) {
					System.out.println("There is no person called " + orderList[1]);
				}
				else if(b==null) {
					System.out.println("There is no person called " + orderList[2]);
				}
				//else, set the first name to be the parent of the second name
				else {
				b.addParent(a);
				}
			}
			//if user wants to marry two people
			else if(order.charAt(0)=='M') {
				Person a = findPerson(orderList[1]);
				Person b = findPerson(orderList[2]);
				//if no such person exists
				//print warning
				if( a==null) {
					System.out.println("There is no person called " + orderList[1]);
				}
				else if( b==null) {
					System.out.println("There is no person called " + orderList[2]);
				}
				//else, marry two people
				else {
					b.marry(a);
				}
			}
			//if user chooses to divorce
			else if(order.charAt(0)=='D') {
				Person a = findPerson(orderList[1]);
				//if no such person exists
				//print warning
				if( a==null) {
					System.out.println("There is no person called " + orderList[1]);
					break;
				}
				a.divorce();
			}
			//print spouse
			else if(order.charAt(0)=='S') {
				Person a = findPerson(orderList[1]);
				if( a==null) {
					System.out.println("There is no person called " + orderList[1]);
					break;
				}
				a.printSpouse();
			}
			//print all children
			else if(order.charAt(0)=='C') {
				Person a = findPerson(orderList[1]);
				if( a==null) {
					System.out.println("There is no person called " + orderList[1]);
					break;
				}
				a.printChildren();
			}
			//if user want to check the relation between two person
			else if(order.charAt(0)=='Z') {
				Person a = findPerson(orderList[1]);
				Person b = findPerson(orderList[2]);
				if (a.isDecendant(b)==true) {
					System.out.println("Yes!");
				}
				else {
					System.out.println("No!");
				}
			}
			//print decdescendant
			else if(order.charAt(0)=='T') {
				Person a = findPerson(orderList[1]);
				a.displayPreorderChildren();
			}
			//print ancestor
			else if(order.charAt(0)=='U') {
				Person a = findPerson(orderList[1]);
				a.displayPreorderParent();
			}
		}
	}

}
