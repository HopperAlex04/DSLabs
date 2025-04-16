package Lab07;
import java.util.Scanner;

public class NQueens 
{
    private static boolean[][] rows;

    public static int solve(int n)
    {
        rows = new boolean[n][n];
        return solve(n, 0, rows);
    }

    private static int solve(int n, int q, boolean[][] rows)
    {
        if (q == n) return 1;
        int sols = 0;
        for (int i = 0; i < n; i++)
        {
            if (is_safe(rows, q, i))
            {
                rows[q][i] = true;
                sols += solve(n, q + 1, rows);
                rows[q][i] = false;
            }
        }
        return sols;
    }

    private static boolean is_safe(boolean[][] rows, int r, int c)
    {
        int n = rows.length;
        int left = c;
        int right = c;
        while (r >= 0)
        {
            if (left >= 0 && rows[r][left] == true
                || rows[r][c] == true
                || right < n && rows[r][right] == true) return false;
            r--;
            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int c = solve(s.nextInt());
        System.out.println("The number of valid arrangements is " + c);
        s.close();
    }
}
