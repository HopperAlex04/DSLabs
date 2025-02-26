import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test 
{
    public static void main(String args[]) throws FileNotFoundException
    {
        File f = new File("Lab03\\dictionary.txt");
        StringSet s = new StringSet();
        Scanner ss = new Scanner(f);
        while (ss.hasNextLine())
        {
            s.insert(ss.nextLine());
        }
        s.print();
        ss.close();
    }
}
