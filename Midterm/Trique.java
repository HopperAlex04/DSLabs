import java.util.Scanner;
class Trique
{
    Node back;
    Node front;
    Node mid;
    int size;
    int m;

    private class Node
    {
        private int data;
        private Node next;
        private Node before;

        public Node(int d, Node n, Node b)
        {
            data = d;
            next = n;
            before = b;
        }
    }

    public Trique()
    {
        size = 0;
        m = 0;
    }

    private void push_back(int x)
    {
        if (size == 0)
        {
            back = new Node(x, null, null);
            front = back;
            mid = back;
        }
        else
        {
            back.next = new Node(x, null, back);
            back = back.next;
            //System.out.println(back.data);
        }
        size++;
        //System.out.println(size);
        if (size > 1)
        {
            mid = mid.next;
        }
        if ((size) / 2 > m)
        {
            m = (size) / 2;
        }
    }

    private void push_front(int x)
    {
        if (size == 0)
        {
            front = new Node(x, front, null);
            back = front;
            mid = front;
        }
        else
        {
            front.before = new Node(x, front, null);
            front = front.before;
        }
        size++;
        if (size > 2)
        {
            mid = mid.before;
        }
        if ((size) / 2 > m)
        {
            m = (size) / 2;
        }
    }

    private void push_mid(int x)
    {
        if (size == 0)
        {
            mid = new Node(x, null, null);
            front = mid;
            back = mid;
        }
        if (size % 2 == 1)
        {
            Node newNode = new Node(x, mid.next, mid);
            mid.next.before = newNode;
            mid.next = newNode;
            m++;
        }
        else
        {
            Node newNode = new Node(x, mid, mid.before);
            mid.before.next = newNode;
            mid.before = newNode;
            mid = newNode;
            //System.out.println("inmid");
            //System.out.println(mid.before.data);
            //System.err.println(mid.data);
            //System.out.println(mid.next.data);
            //System.out.println(m);
        }
        size++;
        if ((size) / 2 > m)
        {
            m = (size) / 2;
        }        
    }

    public void get(int i)
    {
        int s = 0;
        Node p;
        /*if (i < m)
        {
            p = front;
        }
        else if (i >= m)
        {
            //System.out.println("atmid ");
            p = mid;
            s = m;
        }
        else
        {
            p = null;
        }
    */
        p = front;
        while (s < i && p != null)
        {
            //System.out.println(p.data);
            p = p.next;
            s++;
        }
        if (p != null)
        {
            System.out.println(p.data);
        }
    }

    public static void main(String[] args) 
    {
        Trique t = new Trique();
        Scanner s = new Scanner(System.in);
        String in = "";
        while(!in.equals("end"))
        {
            in = s.nextLine();
            if (in.charAt(0) == 'p' && in.charAt(5) == 'b')
            {
                t.push_back(in.charAt(10) - '0');
            }
            if (in.charAt(0) == 'p' && in.charAt(5) == 'f')
            {
                t.push_front(in.charAt(11) - '0');
            }
            if (in.charAt(0) == 'p' && in.charAt(5) == 'm')
            {
                t.push_mid(in.charAt(9) - '0');
            }
            if (in.charAt(0) == 'g')
            {
                t.get(in.charAt(4) - '0');
            }
        }
        s.close();
    }
}