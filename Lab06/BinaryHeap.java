public class BinaryHeap
{
	public int[] data;   // data array
	public int numItems; // number of items stored in the data array

	public BinaryHeap()
	{
		data = new int[100];
		numItems = 0;
	}

	public void insert(int k)
	{
		// TODO: insert into the binary heap
		// insert at the last location, increment size, and sift-up
		// might require a resize if heap is full
		if (numItems + 1 == data.length)
		{
			int[] copy = new int[(data.length * 2) + 1];
			int i = 0;
			for (int x : data)
			{
				copy[i] = x;
				i++;
			}
			data = copy;
		}
		data[numItems] = k;
		sift_up(numItems);
		numItems++;
	}

	public int remove_min()
	{
		// TODO: return smallest value (stored at root) and remove
		// swap with last location, decrement size, then sift-down the new root
		int min = data[0];
		data[0] = data[numItems - 1];
		numItems--;
		sift_down(0);
		return min;
	}

	public int find_min()
	{
		// TODO: return smallest value (stored at root)
		return data[0];
	}

	public int size()
	{
		return numItems;
	}

	private void sift_up(int i)
	{
		// TODO: fix heap violations at location i by swapping with parent if needed
		while (data[i] < data[(i-1)/2])
		{
			//System.out.println("sup");
			int temp = data[i];
			data[i] = data[(i-1)/2];
			data[(i-1)/2] = temp;
			i = (i-1)/2;
			if (i < 0) i = 0;
		}
	}

	private void sift_down(int i)
	{
		// TODO: fix heap violations at location i by swapping with smallest child
		if ((2 * i) + 1 < numItems || (2 * i) + 2 < numItems)
		{
			if (data[(2 * i) + 1] < data[i] || data[(2 * i) + 2] < data[i])
			{
				int temp = 0;
				if (data[(2 * i) + 1] <= data[(2 * i) + 2])
				{
					temp = data[(2 * i) + 1];
					data[(2 * i) + 1] = data[i];
					data[i] = temp;
					//System.out.println(temp);
					sift_down((2 * i) + 1);
				}
				else
				{
					temp = data[(2 * i) + 2];
					data[(2 * i) + 2] = data[i];
					data[i] = temp;
					//System.out.println(temp);
					sift_down((2 * i) + 2);
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		BinaryHeap b = new BinaryHeap();
		for (int i = 0; i < 15; i++)
		{
			b.insert(i);
		}
		for (int i = 0; i < b.numItems; i++)
		{
			for (int j = 0; j < b.numItems; j++)
			{
				//System.out.print(b.data[j] + " ");
			}
			System.out.println();
			b.remove_min();
			System.out.println(b.numItems);
			for (int j = 0; j < b.numItems; j++)
			{
				System.out.print(b.data[j] + " ");
			}
		}	
	}
}
