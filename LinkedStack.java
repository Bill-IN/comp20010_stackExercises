/**
 * Link-based stack implementation of Stack interface.
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> 
{
	//constructors
	LinkedStack(){}
	
	//Accessors
	/**
	 * 
	 * @return returns the number of elements in the stack.
	 */
	public int size()
	{
		return list.size();
	}

	/**
	 * Tests whether the stack is empty.
	 * @return
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	//Mutators
	/**
	 *  Inserts element at the top of the stack.
	 *  
	 *  @param element
	 */
	public void push(E element)
	{
		list.addFirst(element);
		//list.addLast(element);
	}
	
	/**
	 * Returns the top element of the stack but doesn't remove it.
	 * @return 
	 */
	public E top()
	{
		return list.first();
		//return list.last();
	}
	
	/**
	 * Removes and returns the top element of the stack.
	 * @return
	 */
	public E pop()
	{
		return list.removeFirst();
		//return list.removeLast();
	}
	
	/**
	 * @return String representation of the Stack
	 */
	@Override
	public String toString()
	{
		return list.toString();
	}
	
	//attributes
	private GenericSinglyLinkedList<E> list = new GenericSinglyLinkedList<E>();
	
	//Main method
	public static void main(String[] args)
	{
		LinkedStack<Integer> numbers = new LinkedStack<Integer>();
		
		numbers.push(1);
		numbers.push(2);
		numbers.push(3);
		numbers.push(4);
		numbers.push(5);
		numbers.push(6);
		
		System.out.println("Stack: " + numbers.toString());
		
		while(!numbers.isEmpty())
		{
			System.out.println("pop: " + numbers.pop() + "  Stack: " + numbers.toString());
		}	
		
		System.out.println("pop: " + numbers.pop() + "  Stack: " + numbers.toString());
	}
}
