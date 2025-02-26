import java.util.Scanner;
import java.io.*;
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

    public int hash(double key)
    {
        return (int)(key * b) / c;
    }

    public void insert(double x, double y)
    {
        map[hash(y)][hash(x)] =  new Node(x, y, map[hash(y)][hash(x)]);
    }

    private static class Node
	{
		public double x;
        public double y;
		public Node next;

		public Node(double x, double y, Node next)
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
            for (int j = 0; j < map[i].length; j++)
            {
                for (Node k = map[i][j]; k != null; k = k.next)
                {
                    System.out.println(k.x + ", " + k.y);
                }
                System.out.println(j + ", " + i);
            }
        }
    }

    public static void main(String args[]) throws FileNotFoundException
    {
        File f = new File("Lab03\\points.txt");
        Scanner s = new Scanner(f);
        
        Closest sol = new Closest(1000000, 10);
        while (s.hasNext())
        {
            sol.insert(s.nextDouble(), s.nextDouble());
        }
        sol.print();
    }

}
