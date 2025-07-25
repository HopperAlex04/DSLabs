package Lab07;
import java.util.Scanner;

public class Collatz 
{
    private static Node[] memo;

    public static int collatzLength(long x)
    {
        return collatzLength(x, memo);
    }

    private static int collatzLength(long x, Node[] memo)
    {
        int cl = 0;
        if (x == 1) return 1;
        if (memo != null)
        {
            for (Node p = memo[(int)(x % 10000)]; p != null; p = p.next)
            {
                if (p.data == x) return p.clength;
            }
        }
        if (x % 2 == 0)
        {
            cl = 1 + collatzLength(x / 2, memo);
            if (memo != null) insert(x, cl);
        }
        else if ( x % 2 == 1)
        {
            cl = 1 + collatzLength((3 * x) + 1, memo);
            if (memo != null) insert(x, cl);
        }
        return cl;
    }

    public static long longestInRange(long a, long b)
    {
        memo = new Node[10000];
        long max = 0;
        int cl = 0;
        for (long i = a; i < b + 1; i++)
        {
           if (cl < collatzLength(i, memo))
           {
                max = i;
                cl = collatzLength(i, memo);
           }
        }
        return max;
    }

    private static void insert(long x, int cl)
    {
        memo[(int)(x % 10000)] = new Node(x, cl, memo[(int)(x % 10000)]);
    }

    private static class Node
    {
        long data;
        int clength;
        Node next;

        public Node(long d, int c, Node n)
        {
            data = d;
            clength = c;
            next = n;
        }
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the range: ");
        long l = longestInRange(s.nextInt(), s.nextInt());
        int cl = collatzLength(l);
        System.out.println("The number with the greatest Collatz length in this range: " + l);
        System.out.println("The Collatz length of " + l + " is " + cl);
        s.close();
    }
}
