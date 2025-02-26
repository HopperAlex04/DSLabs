public class StringSet {
	private static class Node
	{
		public String data;
		public Node next;

		public Node(String data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}

	private Node[] table;
	private int size;

	public StringSet()
	{
		size = 0;
		table = new Node[100];
	}

	public void insert(String key)
	{
		if (size == table.length)
		{
			// TODO: expand the hash table and rehash its contents
			StringSet temp = new StringSet();
			temp.table = new Node[table.length * 2];
			//System.out.println("resizing");
			for (int i = 0; i < table.length; i++)
			{
				//int n = 0;
				for (Node p = table[i]; p != null; p = p.next)
				{
					temp.insert(p.data);
					//n++;
				}
				//System.out.println("hash done " + n + " " + i);
			}
			this.table = temp.table;
		}
		// TODO: code for insert
		table[hash(key)] = new Node(key, table[hash(key)]); 
		size++;
	}

	public boolean find(String key)
	{	
		// TODO: return true if the key is present, false otherwise
		Node p = table[hash(key)];
		while(p != null && !p.data.equals(key)) 
		{	
			p = p.next;
		}
		return p != null;
	}

	public void print()
	{
		// TODO: print the contents of the hash table
		for (int i = 0; i < table.length; i++)
		{
			for (Node p = table[i]; p != null; p = p.next)
			{
				System.out.println(p.data);
			}
			//System.out.println("hash done " + i);
		}
	}

	public int hash(String key)
	{
		int h = 0;
		//10069 haha funi number , 13
		// TODO: compute a polynomial hash function for the String k
		// the returned value should be a valid index into the table
		// i.e, in the range [0..n-1] where n = table.length
		int x = 13;
		for (int i = 0; i < key.length(); i++)
		{
			h = (h * x + key.charAt(i)) % 10069;
		}
		return h % table.length;
	}
}
