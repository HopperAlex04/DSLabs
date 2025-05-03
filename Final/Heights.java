import java.util.Scanner;

public class Heights 
{
    Node root;

    private class Node 
    {
        private int data;
        private Node left;
        private Node right;

        Node (int d, Node l, Node r)
        {
            data = d;
            left = l;
            right = r;
        }
    }
    
    public Heights()
    {
        root = null;
    }

    private void insert(int d)
    {
        root = insert(root, d);
    }

    private Node insert(Node t, int d)
    {
        if (t == null) return new Node(d, null, null);
        if (d < t.data) t.left = insert(t.left, d);
        else if (d > t.data) t.right = insert(t.right, d);

        return t;
    }

    // private void inorder(Node t)
    // {
    //     if (t == null) return;
    //     inorder(t.left);
    //     System.out.println(t.data);
    //     inorder(t.right);
    // }

    // private Node max(Node t)
    // {
    //     if (t.right == null) return t;
    //     return max(t.right);
    // }

    private Node pred(int d, Node p, Node t)
    {
        if (t == null) return p;
        
        if (d > t.data) return pred(d, t, t.right);
        else if (d < t.data) return pred(d, p, t.left);

        return p;
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        Heights h = new Heights();
        
        for (int i = 0; i < n; i++)
        {
            h.insert(s.nextInt());
        }

        for (int i = 0; i < q; i++)
        {
            int p = s.nextInt();
            Node low = h.pred(p, null, h.root);
            System.out.print(p + " ");
            if (low == null) System.out.println("0");
            else System.out.println(low.data);
        }
        s.close();
    }

}
