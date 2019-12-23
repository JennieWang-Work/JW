
// Tree1.java
// Children are kept in an array. Upward and downward pointers.
//


public class Tree1<T> {

    private T label;
    private Tree1<T>[] parent;
    private Tree1<T>[] children;  // Array of children
    private int numChildren = 0;  // Number of children
    private int numParent = 0;

// Constructor
    
    public Tree1(T l, Tree1<T>[] c) {
        label=l; 
        children = c;
      }

// getters
    public T getLabel() { return label; }
    public Tree1<T>[] getParent() { return parent; }
    public Tree1<T>[] getChildren() { return children; }
    public int  getNumChildren() { return numChildren; }

// Add  node C as a child of this.

    public void addChild(Tree1<T> c) { 
        if (numChildren < children.length) {
           children[numChildren] = c;
           numChildren++;
           c.parent[numParent] = this;
           numParent++;
        }
     }

    public void displayPreorder() {
        displayPreorder1(0);
      }

    public void displayPreorder1(int indent) {
       for (int I = 0; I < indent; I++) System.out.print(" ");
         System.out.println(label.toString());
       for (int I=0; I < numChildren; I++)
         children[I].displayPreorder1(indent+3);
     }
  
    public void displayPostorder() {
        displayPostorder1(0);
      }

    public void displayPostorder1(int indent) {
       for (int I=0; I < numChildren; I++)
         children[I].displayPostorder1(indent+3);
       for (int I = 0; I < indent; I++) System.out.print(" ");
         System.out.println(label.toString());
     }

}