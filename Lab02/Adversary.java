import java.lang.Integer;
import java.util.Random;
public class Adversary
{
	public static void main(String [] args)
	{	
		if (args.length != 2)
		{
			System.out.println("Usage: java Adversary <input size> <hash function>");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p)
		{
			case 1: func1(n); break;
			case 2: func2(n); break;
			case 3: func3(n); break;
			case 4: func4(n); break;
			default: System.out.println("Invalid function number. Expected 1-4.");
		}
	}

	private static void func1(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.
		for (int i = 0; i < n; i++)
		{
			System.out.println(n*i);
		}
	}

	private static void func2(int n) {
		for (int i = 0; i < n; i++)
		{
			System.out.println(i);
		}
	}

	private static void func3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.
		int count = 0;
		for(int i = 0; i < n*n && count < n; i++)
		{
			if (((int) (((2971L * i + 101923L) % 128189L)  % (long) n)) == 2)
			{
				System.out.println(i);
				count++;
			}
		}	
	}

	class Node
	{
		private int data;
		private Node next;
		public Node(int d, Node n)
		{
			data = d;
			next = n;
		}
	}

	private static void func4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.	
		Adversary a = new Adversary();
		Node[] arr = new Node[n];
		int[] sizeArr = new int[n];
		int i = 0;
		int hashSize = 0;
		Random rand = new Random();
		while (hashSize < n)
		{
			rand.setSeed(i);
			hashSize = 0;
			int hash = rand.nextInt(n);
			arr[hash] = a.new Node(i, arr[hash]);
			sizeArr[hash]++;
			hashSize = sizeArr[hash];
			if (hashSize >= n)
			{
				for(Node p = arr[hash]; p.next != null; p = p.next)
				{	
					System.out.println(p.data);
				}
			}
			i++;
		}
	}
}
