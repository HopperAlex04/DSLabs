import java.util.Scanner;

class Jigsaw
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        boolean[] arr = new boolean[k];
        int n = s.nextInt();
        //int k = 10 * 10 * 10 * 10 * 10 * 10;
        //int n = 10 * 10 * 10 * 10 * 10 * 10 * 10;
        //System.out.println(k);
        //boolean[] arr = new boolean[k];
        for (int i = 0; i < n; i++)
        {
            arr[s.nextInt() - 1] = true; 
            //if (i < k) arr[i] = true;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (!arr[i])
            {
                count++;
            }
        }
        if (count != 0)
        {
            System.out.println("Missing " + count + " jigsaw piece(s).");
        }
        else
        {
            System.out.println("The puzzle is complete.");
        }
        s.close();
    }

}