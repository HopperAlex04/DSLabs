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
			}
			else if (command == 'q')
			{
				// TODO: calculate the median, store it in m
				System.out.println(m);
			}
			else break;
		}
	}
}
