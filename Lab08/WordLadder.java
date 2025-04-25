import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;

public class WordLadder 
{
    private static HashMap<String, String> visPath;
    private static Queue<String> q;

    // private static void shortLadder(String s)
    // {
    //     q = new LinkedList<String>();
    //     return bfs(s);
    // }

    private static void bfs(String s, String c)
    {
        q.add(s);
        while (!q.isEmpty())
        {
            String i = q.remove();
            for (int k = 0; k < i.length(); k++)
            {
                StringBuilder sb = new StringBuilder("");
                sb.append(i);
                //System.out.println(sb.toString());
                for (char j = 'a'; j <= 'z'; j++)
                {
                    sb.setCharAt(k, j);
                    //System.out.println(sb.toString());
                    if (visPath.containsKey(sb.toString()) && visPath.get(sb.toString()).equals("") && !sb.toString().equals(s))
                    {
                        visPath.put(sb.toString(), i);
                        //System.out.println(sb.toString());
                        q.add(sb.toString());
                    }
                    if (c.equals(sb.toString()))
                    {
                        System.out.println("Possible!");
                        LinkedList<String> path = new LinkedList<>();
                        for (String p = c; !visPath.get(p).equals(""); p = visPath.get(p))
                        {
                            path.addLast(p);
                        }
                        path.addLast(s);
                        while (!path.isEmpty())
                        {
                            System.out.println(path.removeLast());
                        }
                        return;
                    }
                }
            }
            //System.out.println(q);
        }
        System.out.println("Impossible!");
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("dictionary4.txt");
        Scanner s = new Scanner(f);
        visPath = new HashMap<>();
        while (s.hasNextLine())
        {
            visPath.put(s.nextLine(), "");
        }
        s.close();
        q = new LinkedList<>();
        s = new Scanner(System.in);
        System.out.print("Enter the start word: ");
        String a = s.nextLine();
        System.out.print("Enter the end word: ");
        String b = s.nextLine();
        bfs(a, b);
        //System.out.println(visPath.get("lose"));
        s.close();
    }
}
