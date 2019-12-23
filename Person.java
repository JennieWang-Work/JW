public class Person {


    public String name;
    public Person node;
    public Person[] parents;
    public Person[] children;  // Array of children
    public int numChildren = 0;  // Number of children
    public int numParent = 0;
	public Person spouse;
	public static int MaxChildren=20;
	public static int MaxParent=20;
	  
// Constructor
    
    public Person(String l) {
        name=l; 
        children = new Person[MaxChildren];
        parents= new Person[MaxParent];
      }
    
    
// getters]
    public String getName() { return name; }
    public Person[] getParents() { return parents; }
    public Person[] getChildren() { return children; }
    public int getNumChildren() { return numChildren;}
    public Person getSpouse() { return spouse;}
    public void setSpouse(Person x) { this.spouse = x;}

   // check if q is a decendant of this 
    public boolean isDecendant(Person q) {
    	if (numChildren==0) {
    		return false;
    	}
    	for(int i =0; i< numChildren;i++){
    		if (this.children[i]==q) {
    			return true;
    		}
		//recursion
    		if(this.children[i].isDecendant(q)==true) {
    			return true;
    		}
    	}
    	return false;
    }
    // Add  node C as a child of this.

    public boolean addParent(Person q) {
        boolean succeed = false;
           if (q == null) System.out.println("Parent is null");
           else if (this==q) 
                   System.out.println("A person cannot be their own parent");
           else if (this.numParent>= MaxParent) 
                   System.out.println(name + " already has "+MaxParent+" parents.");
           else if(this.isDecendant(q)==true) {
         	   System.out.println(q.name+" is a decendant of "+ this.getName());
            }
           else if(q.isDecendant(this)==true) {
         	   System.out.println(this.name+" is a decendant of "+ q.getName());
            }
        
           else if (q.getNumChildren() >= MaxChildren)
                   System.out.println(q.name + " already has " + MaxChildren + " children.");
           else  {
        	   q.children[q.numChildren] = this;
        	   q.numChildren++;
        	   this.parents[this.numParent] = q;
        	   this.numParent++;
               succeed = true;
              }
       return succeed;
    } //end addParent
    

    public void displayPreorderChildren() {
        displayPreorderChildren1(0);
      }

    public void displayPreorderChildren1(int indent) {
       for (int I = 0; I < indent; I++) System.out.print(" ");
         System.out.println(name.toString());
       for (int I=0; I < numChildren; I++)
         children[I].displayPreorderChildren1(indent+3);
     }
    
    public void displayPreorderParent() {
        displayPreorderParent1(0);
      }

    public void displayPreorderParent1(int indent) {
       for (int I = 0; I < indent; I++) System.out.print(" ");
         System.out.println(name.toString());
       for (int I=0; I < numParent; I++)
         parents[I].displayPreorderParent1(indent+3);
     }
    
    
  //method to marry two person
    //return true if successful, else, return false
    public boolean marry(Person q) {
        boolean succeed = false;
        //if q is null, output the warning person is null
	     if (q == null) {
	    	 System.out.println("Person is null.");
	     }
	     //if one of the person has already have spouse
	     //print out the warning
	     else if (this.getSpouse() != null) {
	    	 System.out.println(name + " is already married.");
	     }
	    else if (q.getSpouse() != null) {
            System.out.println(q.name + "is already married.");}
	     // if one of the person is the other's parent
	     // print out the warning
	    else if(this.isDecendant(q)==true) {
     	   System.out.println(q.name+" is a decendant of "+ this.getName());
        }
        else if(q.isDecendant(this)==true) {
     	   System.out.println(this.name+" is a decendant of "+ q.getName());
        }
	     //else, calling setSpouse(Person a)
	    else{
			this.setSpouse(q); 
			q.setSpouse(this); 
			succeed = true;}
	     return succeed;
	}// end marry method
    
    //divorce method
    //if successful, return true
    //else, return false
    public boolean divorce() {
   	 boolean succeed = false;
   	 //if he or she does not have a spouse
   	 //print the warning that the person is not married
   	 if (this.getSpouse() == null) {
   		 System.out.println("This person is not married"); } 
   	 //else,
   	 //set the person's spouse to null
   	 else {
   		 this.getSpouse().setSpouse(null);
   		 this.setSpouse(null); 
   		 succeed = true;}
   	 return succeed;
   	 }
    
    //method to print out the spouse
    public void printSpouse(){
   	 System.out.println(getSpouse().getName()); }
    
    //method to print out children
    public void printChildren() {
   	 for (int i = 0; i < numChildren; i++) {
   	 System.out.print(children[i].getName()+ " "); }
   	 System.out.println();
   	 }
} // end Person
  

