/**
 * Generic implementation of singly linked list.
 * 
 * @param <E>
 */
import java.util.Iterator;

public class GenericSinglyLinkedList<E> 
{
	
	/**
	 * Node of a singly linked list, which stores a reference to its element and to
	 * the subsequent node in the list (or null if this is the last node).
	 */
	private static class Node<E> 
	{

		/** The element stored at this node */
		private E element; // reference to the element stored at this node

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e: the element to be stored
		 * @param n: reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> n) 
		{
			// TODO
			this.element = e;
			this.next = n;
		}

		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() 
		{
			// TODO
			return this.element;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() 
		{
			// TODO
			return this.next;
		}

		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n
		 *            the node that should follow this one
		 */
		public void setNext(Node<E> n) 
		{
			// TODO
			this.next = n;
		}
		
	}

	// instance variables of the SinglyLinkedList
	/** The head node of the list */
	private Node<E> head = null; // head node of the list (or null if empty)

	/** The last node of the list */
	private Node<E> tail = null; // last node of the list (or null if empty)

	/** Number of nodes in the list */
	private int size = 0; // number of nodes in the list

	
	
	/** Constructs an initially empty list. */
	public GenericSinglyLinkedList() {} 

	// access methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() 
	{
		// TODO
		return this.size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() 
	{
		// TODO
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() 
	{ // returns (but does not remove) the first element
		// TODO
		if(isEmpty())
		{
			return null;
		}
		
		return head.getElement();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() 
	{ // returns (but does not remove) the last element
		// TODO
		if(isEmpty())
		{
			return null;
		}
		
		return tail.getElement();
	}

	// update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) 
	{ // adds element e to the front of the list
		// TODO
		
		/*Make the new node the head and have its next reference be the 
		 previous head of the list.*/
		this.head = new Node<E>(e, head);
		
		/*If the list is empty then make the head the tail aswell.*/
		if(isEmpty())
		{
			this.tail = head;
		}
		
		size++;
	}


	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e
	 *            the new element to add
	 */
	public void addLast(E e) 
	{ // adds element e to the end of the list
		// TODO
		Node<E> newTail = new Node<E>(e, null);
		
		//Make the head the tail aswell if the list is empty.
		if(isEmpty())
		{
			this.head = newTail;
			this.tail = this.head;//Make the newTail the head and the tail.
		}
		
		else
		{
			tail.setNext(newTail);
			tail = newTail;
		}
		
		size++;

	}

	
	public void insertBefore(E key, E s) 
	{
		// TODO
		
		//Can't traverse the list if the head is null.
		if(head == null)
		{
			return;
		}
		
		/*If the head has the key then insert the new node before the head.
		e.g. make it the new head of the list.*/
		if(head.getElement().equals(key))
		{
			addFirst(s);
			return;//Don't need to continue past this point if this condition is met.
		}
		
		Node<E> prev = null;
		Node<E> curr = head;
		
		while(curr != null && !curr.getElement().equals(key))
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		//We are not at the tail
		if(curr != null)
		{
			//Insert new node between previous and current.
			prev.setNext(new Node<E>(s, curr));
		}
		
		size++;
	}

	public void remove(E key) 
	{
		// TODO
		
		//If the head is null, e.g. the list is empty
		if(head == null)
		{
			System.out.print("Cannot delete");
			return;//Exit the method but don't stop the program.
			
			//throw new RunTimeException("Cannot delete")
		}
		
		//if we are deleting the head.
		if(head.getElement().equals(key))
		{
			head = head.next;//Changing attribute of Node class in method.Not using accessor method.
			return;
		}
		
		Node<E> prev = null;
		Node<E> curr = head;
		
		while(curr != null && !curr.getElement().equals(key))
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		//We are at the end of the list.
		if(curr == null)
		{
			System.out.print("Cannot delete");
			return;//Exit the method but don't stop the program.
		}
		
		//Delete the node.
		prev.next = curr.next;
		size--;
		
	}
	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() 
	{ // removes and returns the first element
		// TODO
		
		//if list is empty
		if(head == null)
		{
			throw new RuntimeException("Cannot delete");
		}
		
		E result = head.getElement();
		head = head.next;
		size--;
		
		return result;
	}
	
	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() 
	{ // removes and returns the last element
		// TODO
		
		//if list is empty
		if(head == null)
		{
			throw new RuntimeException("Cannot delete");
		}
		
		E result = tail.getElement();
		
		//
		Node<E> prev = null;
		Node<E> curr = head;
		
		while(curr != null)
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		tail = prev;
	
		size--;
		
		return result;
	}


	public Object copy() 
	{
		// TODO
		GenericSinglyLinkedList<E> twin = new GenericSinglyLinkedList<E>();
		Node<E> tmp = head;
		
		while(tmp != null)
		{
			twin.addLast(tmp.getElement());
			tmp = tmp.next;
		}
		
		return twin;
	}
	
	
	public boolean equals(GenericSinglyLinkedList<E> list)
	{
		int match = 0;
				
		//Check if the arrays are the same size.
		if(this.size() == list.size())
		{
			//Check if the lists have same values.
			Iterator<E> itList = list.iterator();
			
			Node<E> tmp = head;
			
			while(tmp != null && itList.hasNext())
			{
				if(tmp.getElement().equals(itList.next()))
				{
					match++;
					//System.out.println("!!!!!!" + "   " + tmp.getElement());
				}
				
				System.out.println("!!!!!!" + "   " + tmp.getElement());
				tmp = tmp.next;
			}
		}
		
		//If all elements are the same => same length because nested if,return true
		if(match == list.size())
		{
			return true;			
		}
		
		else
		{
			return false;
		}
	}


	public Iterator<E> iterator() 
	{
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E> 
	{
		// TODO
		Node<E> curr;
		
		public ListIterator()
		{
			curr = head;
		}
		
		public boolean hasNext()
		{
			return curr != null;
		}
		
		@Override
		public E next()
		{
			E result = curr.getElement();
			curr = curr.getNext();
			return result;
		}
	}
	/**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   * 
   * @Override
   */
  public String toString() 
  {
	  // TODO
	  String output = "[  ";
	  
	  for(Iterator<E> it = iterator(); it.hasNext(); ) 
	  {
		 output += it.next() + "  ";
	  }	  
	  
	  output += "]";
	  
	  return output;
  }
  
  public static void main(String[] args) 
  {
	  GenericSinglyLinkedList<String> shoppingList = new GenericSinglyLinkedList<String>();
	  GenericSinglyLinkedList<String> shoppingList2 = new GenericSinglyLinkedList<String>();

	  
	  shoppingList.addLast("Milk");
	  shoppingList.addLast("Sugar");
	  shoppingList.addLast("Banana");
	  shoppingList.addLast("Apple");
	  shoppingList.addLast("Orange");
	  shoppingList.addLast("Eggs");
	  
	  shoppingList2.addLast("Milk");
	  shoppingList2.addLast("Sugar");
	  shoppingList2.addLast("Banana");
	  shoppingList2.addLast("Apple");
	  shoppingList2.addLast("Orange");
	  shoppingList2.addLast("Eggs");
	  
	  
	  if(shoppingList.equals(shoppingList2))
	  {
		  System.out.println(shoppingList.toString() + " " + shoppingList.size());
		  @SuppressWarnings("unchecked")
		  GenericSinglyLinkedList<String> shoppingListCopy = (GenericSinglyLinkedList<String>) shoppingList.copy();
		  System.out.println(shoppingListCopy.toString() + " " + shoppingListCopy.size());

	  }
	  
	  else
	  {
		  System.out.println("RRRRRRRaaaaaahhhhhhhh");		  
	  }

  }
}
