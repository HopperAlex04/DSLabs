import java.util.Scanner;
import java.io.*;

public class Closest 
{
    private int c;
    private int b;
    Node[][] map;
    Node c1; 
    Node c2;

    public Closest(int b , int c)
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
            for (int j = 0; j < map[i] . length; j++)
            {
                for (Node k = map[i][j]; k != null; k = k.next)
                {
                    //System.out.print(k.x + ", " + k.y + " ");
                }
                //System.out.print(j + ", " + i + "\t");
                
            }
            //System.out.println();
        }
    }

    public void closer()
    {
        double c = 0;
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                for (Node p = map[i][j]; p != null; p = p.next)
                {
                    for (int k = i - 1; k < i + 1; k++)
                    {
                        for (int n = j - 1; n < j + 1; n++)
                        {
                            if (k >= 0 && n >= 0 && n < map.length && k < map[j].length)
                            {
                                for (Node m = map[k][n]; m != null; m = m.next)
                                {
                                    double d = dist(p.x, p.y, m.x, m.y);
                                    if ((c == 0 || c > d) && m != p)
                                    {
                                        c = d;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(c);
    }

    public double dist(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String args[]) throws FileNotFoundException
    {
        //File f = new File("points.txt");
        Scanner s = new Scanner(System.in);
        Closest sol = new Closest(1000, 1000000);
        while (s.hasNext())
        {
            sol.insert(s.nextDouble(), s.nextDouble());
        }
        //sol.print();
        sol.closer();
        //System.out.println(sol.dist(144046.222, 35821.043, 915938.754, 718755.458));
        s.close();
        
    }

}
