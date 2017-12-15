/**
 * Vector-based implementation of the stack interface.
 * 
 * @param<E>
 */
import java.util.Vector;

public class VectorStack<E> 
{
	//Constructor
	VectorStack(){}
	
	//Accessors
	/**
	 * 
	 * @return returns the number of elements in the stack.
	 */
	public int size()
	{
		return data.size();
	}

	/**
	 * Tests whether the stack is empty.
	 * @return
	 */
	public boolean isEmpty()
	{
		return data.isEmpty();
	}
	
	/**
	 * Returns the top element of the stack but doesn't remove it.
	 * @return 
	 */
	public E top()
	{
		return data.lastElement();
	}
	
	//Mutators
	/**
	 *  Inserts element at the top of the stack.
	 *  
	 *  @param element
	 */
	public void push(E element)
	{
		data.addElement(element);
	}
	
	/**
	 * Removes and returns the top element of the stack.
	 * @return
	 */
	public E pop()
	{
		E tmp = this.top();
		data.removeElementAt(data.size() - 1);
		return tmp;
	}
	
	/** 
	 *  @return String representation of the Stack
	 */
	@Override
	public String toString()
	{
		return data.toString();
	}
	
	//Attributes
	private Vector<E> data = new Vector<E>();
	
	
	public static void main(String[] args)
	{
		VectorStack<Integer> numbers = new VectorStack<Integer>();
		
		numbers.push(1);
		numbers.push(2);
		numbers.push(3);
		numbers.push(4);
		numbers.push(5);
		numbers.push(6);
		
		while(!numbers.isEmpty())
		{
			System.out.println(numbers.toString());
			numbers.pop();
		}
	}
}
