import java.util.Scanner;

public class MolecularMass 
{
    IntStack data;
    String input;
    int out;

    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the molecule: ");
        String in = s.nextLine();
        MolecularMass m = new MolecularMass(in);
        System.out.print("The molecular mass of " + in + " is " + m.getOut());
        s.close();
    }   

    public MolecularMass(String s)
    {
        data = new IntStack();
        input = s;
        out = calculate();
    }

    public int calculate()
    {
        int end = 0;
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == 'H')
            {
                data.push(1);
            }
            else if (input.charAt(i) == 'C')
            {
                data.push(12);
            }
            else if (input.charAt(i) == 'O')
            {
                data.push(16);
            }
            else if (input.charAt(i) >= '2' && input.charAt(i) <= '9' )
            {
                data.push(data.pop() * (input.charAt(i) - '0'));
            }
            else if (input.charAt(i) == '(')
            {
                data.push(-1);
            }
            else if (input.charAt(i) == ')')
            {
                int sum = 0;
                int read = data.pop();
                while (read != -1)
                {
                    sum += read;
                    read = data.pop();
                }
                data.push(sum);
            }
        }
        int read = data.pop();
                while (read != -1)
                {
                    end += read;
                    read = data.pop();
                }
        return end;
    }

    public int getOut()
    {
        return out;
    }
}
