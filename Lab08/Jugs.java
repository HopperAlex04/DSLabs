import java.util.Scanner;

class Jugs
{
    private boolean[][] visited;
    private Node[][] path;
    private int a;
    private int b;
    private int c;
    private boolean solved;
    public Jugs(int aCap, int bCap, int target)
    {
        a = aCap;
        b = bCap;
        c = target;
        solved = false;
        path = new Node[a + 1][b + 1];
        path[0][0] = new Node(0, 0, null, null);
        visited = new boolean[a + 1][b + 1];
    }

    private class Node
    {
        int a;
        int b;
        Node next;
        String op;

        public Node(int i, int j, Node pred, String op)
        {
            a = i;
            b = j;
            next = pred;
            this.op = op;
        }
    }
    public void dfs_visit(int i, int j)
    {
        visited[i][j] = true;
        if (i + j == c)
        {
            System.out.println("Possible!\n");
            Node head = null;
            for (Node p = path[i][j]; p != null; p = p.next)
            {
                if (p.a != 0 || p.b != 0) head = new Node(p.a, p.b, head, p.op);
            }

            for (Node p = head; p != null; p = p.next)
            {
                System.out.println(p.op);
            }
            solved = true;
            return;
        }
        int afull = i;
        int bfull = j;
        for (int k = 0; k < 6; k++)
        {
            switch (k)
            {
                case 0:
                    if (!visited[a][j]) 
                    {
                        path[a][j] = new Node(a, j, path[i][j], "A: Fill Jug 1 " + a + " " + j);
                        dfs_visit(a, j);
                    }
                    //System.out.println("fill a");
                    break;
                case 1:
                    if (!visited[i][b])
                    {
                        path[i][b] = new Node(i, b, path[i][j], "B: Fill Jug 1 " + i + " " + b);
                        dfs_visit(i, b);
                    }
                    //System.out.println("fill b");
                    break;
                case 2:
                    if (!visited[0][j]) 
                    {
                        path[0][j] = new Node(0, j, path[i][j], "C: Empty Jug 1 " + 0 + " " + j);
                        dfs_visit(0, j);
                    }
                    break;
                case 3:
                    if (!visited[i][0])
                    {
                        path[i][0] = new Node(i, 0, path[i][j],  "D: Empty Jug 2 " + i + " " + 0);
                        dfs_visit(0, j);
                    }
                    break;
                case 4:
                    while (afull > 0 && bfull < b)
                    {
                        afull--;
                        bfull++;
                    }
                    //System.out.println("afill " + afull + " " + bfull);
                    if (!visited[afull][bfull])
                    {
                        path[afull][bfull] = new Node(afull, bfull, path[i][j],  "E: Pour Jug 1 into 2 " + afull + " " + bfull);
                        dfs_visit(afull, bfull);
                    }
                    break;
                case 5:
                    afull = i;
                    bfull = j;
                    while (bfull > 0 && afull < a)
                    {
                        bfull--;
                        afull++;
                    }
                    //System.out.println("bfill " + afull + " " + bfull);
                    if (!visited[afull][bfull])
                    {
                        path[afull][bfull] = new Node(afull, bfull, path[i][j], "F: Pour Jug 2 into 1 " + afull + " " + bfull);
                        dfs_visit(afull, bfull);
                    }
                    break;
            }
        }
        if (i == 0 && j == 0 && ! solved)
        {
            System.out.println("Impossible!");
        }
    }

        
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter A: ");
        int a = s.nextInt();
        System.out.print("Enter B: ");
        int b = s.nextInt();
        System.out.print("Enter C: ");
        int c = s.nextInt();
        Jugs jug = new Jugs(a,b,c);
        jug.dfs_visit(0, 0);
        s.close();
    }
}