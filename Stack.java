/**
 * Stack ADT interface
 *
 * @param <E>
 */

public interface Stack<E> 
{
	/**
	 * 
	 * @return returns the number of elements in the stack.
	 */
	int size();

	/**
	 * Tests whether the stack is empty.
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 *  Inserts element at the top of the stack.
	 *  
	 *  @param element
	 */
	void push(E element);
	
	/**
	 * Returns the top element of the stack but doesn't remove it.
	 * @return element
	 */
	E top();
	
	/**
	 * Removes and returns the top element of the stack.
	 * @return element
	 */
	E pop();
	
	/**
	 * @return String representation of the Stack
	 */
	String toString();
}
