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
	}

	public int remove_min()
	{
		// TODO: return smallest value (stored at root) and remove
		// swap with last location, decrement size, then sift-down the new root
		return -1;
	}

	public int find_min()
	{
		// TODO: return smallest value (stored at root)
		return -1;
	}

	public int size()
	{
		return numItems;
	}

	private void sift_up(int i)
	{
		// TODO: fix heap violations at location i by swapping with parent if needed
	}

	private void sift_down(int i)
	{
		// TODO: fix heap violations at location i by swapping with smallest child
	}
}
