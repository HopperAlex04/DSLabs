import java.util.Scanner;

public class Median
{
	public static void main(String[] args)
	{
		BinaryHeap small = new BinaryHeap();
		BinaryHeap large = new BinaryHeap();
		Scanner scan = new Scanner(System.in);

		int m = 0, v = 0;
		while (scan.hasNext())
		{
			char command = scan.next().charAt(0);
			if (command == 'i')
			{
				v = scan.nextInt();
				// TODO: insert value v into the dataset
				if (-v <= small.find_min()) small.insert(-v);
				else if (v >= large.find_min()) large.insert(v);
				else small.insert(-v);
				if (small.size() >= large.size() + 1) large.insert(-small.remove_min());
				if (small.size() + 1 <= large.size()) small.insert(-large.remove_min());
			}
			else if (command == 'q')
			{
				// TODO: calculate the median, store it in m
				if (small.size() == large.size()) m = (-small.find_min() + large.find_min()) / 2;
				else if (small.size() < large.size()) m = large.find_min();
				else if (small.size() > large.size()) m = -small.find_min();
				System.out.println(m);
			}
			else break;
		}
	}
}
