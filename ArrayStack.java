import java.util.Arrays;
/**
 * Array based stack ADT implementation
 * 
 * @param<E>
 *
 */
public class ArrayStack<E> implements Stack<E> 
{
	
	//Constructors
	public ArrayStack()
	{ 
		this(CAPACITY);
	}
	
	//Type conversion requires suppress warning
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity)
	{
		data = (E[]) new Object[capacity];
	}
	
	
	//Accessors
	/**
	 * @return size of the stack.
	 */
	public int size()
	{
		//Because topOfStack starts at minus one.
		return (this.topOfStack + 1);
	}

	/**
	 * @return the element at the top of the stack. 
	 */
	public E top()
	{
		if(isEmpty())
		{
			return null;
		}
		
		return data[this.topOfStack];
	}
	
	/**
	 * Check if the stack is empty.
	 */
	public boolean isEmpty()
	{
		return this.size() == 0;
	}
	
	
	//Mutators
	/**
	 * Add an element to the stack.
	 * @param element
	 */
	public void push(E element) throws IllegalStateException
	{
		if(this.size() == data.length)
		{
			throw new IllegalStateException("Stack is full");
		}
		
		data[++this.topOfStack] = element;
	}
	
	/**
	 * Remove the element at the top of the stack.
	 * @return tmp
	 */
	public E pop()
	{
		if(isEmpty())
		{
			return null;
		}
		
		E tmp = data[this.topOfStack];
		data[this.topOfStack] = null;//de-reference to help garbage collection
		this.topOfStack--;
		
		return tmp;
	}
	
	/**
	 * @return String representation of the Stack
	 */
	@Override
	public String toString()
	{
		return Arrays.toString(data);
	}
	
	
	//Attributes
	private int topOfStack = -1;
	private static final int CAPACITY = 1000; 
	private E[] data;
	
	public static void main(String[] args)
	{
		ArrayStack<Integer> numbers = new ArrayStack<Integer>();
		
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
