public class IntStack
{
	// declare your private fields here
	public int top;
	private int[] stackArr;
	/**
	 * Create an empty stack.
	 */
	public IntStack()
	{
		stackArr = new int[10];
		top = 0;
	}

	/** 
	 * Pushes an item onto the top of this stack.
	 * @param x
	 */
	public void push(int x)
	{
		if (top >= stackArr.length)
		{
			int[] big = new int[(stackArr.length * 2) + 1];
			for (int i = 0; i < stackArr.length; i++)
			{
				big[i] = stackArr[i];
			}
			stackArr = big;
		}
		stackArr[top++] = x;

	}

	
	/** 
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * @return int The value removed from the stack. If empty, returns -1
	 */
	public int pop()
	{
		int value  = -1;
		if (top >= 1)
		{
			value = stackArr[--top];
		}
		return value;
	}

	public int getTop()
	{
		return top;
	}
}
