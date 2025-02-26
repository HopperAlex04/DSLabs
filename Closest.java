import java.util.Scanner;

import org.w3c.dom.Node;

public class Closest 
{
    private int c;
    private int b;
    Node[][] map;

    public Closest(int c, int b)
    {
        this.c = c;
        this.b = b;
        map = new Node[b][b];
    }

    public int hash(int key)
    {
        return (key * b) / c;
    }

    public void insert(int x, int y)
    {
        map[hash(y)][hash(x)] =  new Node(x, y, map[hash(y)][hash(x)]);
    }

    private static class Node
	{
		public int x;
        public int y;
		public Node next;

		public Node(int x, int y, Node next)
		{
			this.x = x;
            this.y = y;
			this.next = next;
		}
	}

    public void print()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; i++)
            {
                for (Node k = map[i][j]; k != null; k = k.next)
                {
                    System.out.println(k.x + ", " + k.y);
                }
            }
        }
    }

    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        Closest sol = new Closest(1000000, 10);
        while (s.hasNextLine())
        {
            sol.insert(s.nextInt(), s.nextInt());
        }
    }

}
