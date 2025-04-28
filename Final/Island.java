import java.util.Random;
import java.util.Scanner;

public class Island 
{
    private static int n;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static int count;

    private static void dfs_visit(int i, int j)
    {
        visited[i][j] = true;
        for (int k = i - 1; k < i + 2; k++)
        {
            for (int l = j - 1; l < j + 2; l++)
            {
                if (in(k) && in(l) && !visited[k][l] && map[k][l])
                {
                    dfs_visit(k, l);
                }
            }
        }
    }

    private static boolean in(int index)
    {
        return index >= 0 && index < n;
    }

    private static void full_dfs()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                //System.out.println(map[i][j]);
                if (visited[i][j] == false && map[i][j] == true)
                {
                    dfs_visit(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine();
        count = 0;
        map = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            String in = s.nextLine();
            for (int j = 0; j < n; j++)
            {
                map[i][j] = in.charAt(j) == '*';
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                visited[i][j] = false;
            }
        }
        full_dfs();
        s.close();
    }   
}