class Jugs
{
    private boolean[][] visited;
    private Node[][] path;
    private int a;
    private int b;
    private int c;

    public Jugs(int aCap, int bCap, int target)
    {
        a = aCap;
        b = bCap;
        c = target;
        path = new Node[a + 1][b + 1];
        path[0][0] = new Node(0, 0, null);
        visited = new boolean[a + 1][b + 1];
    }

    private class Node
    {
        int a;
        int b;
        Node next;

        public Node(int i, int j, Node pred)
        {
            a = i;
            b = j;
            next = pred;
        }
    }
    public void dfs_visit(int i, int j)
    {
        visited[i][j] = true;
        if (i + j == c)
        {
            System.out.println("possible");
            Node head = new Node(i, j, null);
            for (Node p = path[i][j].next; p != null; p = p.next)
            {
                head = new Node(p.a, p.b, head);
            }

            for (Node p = head; p != null; p = p.next)
            {
                System.out.println(p.a + " " + p.b);
            }
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
                        path[a][j] = new Node(a, j, path[i][j]);
                        dfs_visit(a, j);
                    }
                    //System.out.println("fill a");
                    break;
                case 1:
                    if (!visited[i][b])
                    {
                        path[i][b] = new Node(i, b, path[i][j]);
                        dfs_visit(i, b);
                    }
                    //System.out.println("fill b");
                    break;
                case 2:
                    if (!visited[0][j]) 
                    {
                        path[0][j] = new Node(0, j, path[i][j]);
                        dfs_visit(0, j);
                    }
                    break;
                case 3:
                    if (!visited[i][0])
                    {
                        path[i][0] = new Node(i, 0, path[i][j]);
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
                        path[afull][bfull] = new Node(afull, bfull, path[i][j]);
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
                        path[afull][bfull] = new Node(afull, bfull, path[i][j]);
                        dfs_visit(afull, bfull);
                    }
                    break;
            }
        }
    }

        
    public static void main(String[] args) 
    {
        Jugs jug = new Jugs(3,4,5);
        jug.dfs_visit(0, 0);
    }
}