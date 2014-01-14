
/**
 * @author Uday Reddy, with changes by Manfred Kerber
 * @version 2013-11-28 based on Uday's version of 2012
 *
 * List class defines a recursive type called List, and provides
 * constructor and getter methods.
 */

public class List {

    private boolean empty;
    private int head;
    private List tail;

    /**
     * The first constructor creates a list consisting of a head, that is,
     * an integer and a tail, which is another list of integers.
     * @param head
     * @param tail
     */
    public List(int head, List tail) {
        this.empty = false;
        this.head = head;
        this.tail = tail;
    }

    /**
     *  The second constructor creates an empty list, i.e., a list with no elements.
     *  For this list, head and tail remain undefined, calls to the corresponding getters
     *  will have to result in an exception.
     */
    public List() {
        this.empty = true;
    }

    /**
     * Creates a new list from a given head element and a tail List
     */
    public static List cons(int head, List tail) {
        return new List(head,tail);
    }

    /**
     * Creates a new empty List
     */
    public static List empty() {
        return new List();
    }

    public boolean getEmpty() {
    	return this.empty;
    }

    public String toString() {
    	return "[" + toStringAux() + "]";
    }

    public String toStringAux() {
       	if (getEmpty()) {
       		return "";
       	} else if (getTail().isEmpty()){
       		return getHead() + "";
       	} else {
       	 	return getHead() + ", " + getTail().toStringAux();
       	}
    }

    public static boolean equals(List l1, List l2) {
    	if (l1.isEmpty() && l2.isEmpty()) {
    		return true;
    	} else if (l1.isEmpty() || l2.isEmpty()) {
    		return false;
    	} else if (l1.getHead() == l2.getHead()) {
    		return equals(l1.getTail(), l2.getTail());
    	} else {
    		return false;
    	}
    }

    /**
     * returns true   public static boolean equals(List l1, List l2) {
    	if (l1.isEmpty() && l2.isEmpty()) {
    		return true;
    	} else if (l1.getHead() == l2.getHead()) {
    		return equals(l1.getTail(), l2.getTail());
    	} else {
    		return false;
    	}
    }
 if this list is empty
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * returns the head of this list or throws an exception if the
     * list is empty
     * @throws IllegalStateException if the list is empty
     */
    public int getHead() {
        if (isEmpty()) {
            throw new IllegalStateException(
                          "Trying to access head of an empty list");
        }
        return head;
    }

    /**
     * returns the tail of this list or throws an exception if the
     * list is empty
     * @throws IllegalStateException if the list is empty
     */
    public List getTail() {
        if (isEmpty()) {
            throw new IllegalStateException(
                          "Trying to access tail of an empty list");
        }
        return tail;
    }

}
