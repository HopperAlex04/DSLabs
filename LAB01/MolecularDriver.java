import java.util.Scanner;
public class MolecularDriver 
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the molecule: ");
        String in = s.nextLine();
        MolecularMass m = new MolecularMass(in);
        System.out.print("The molecular mass of " + in + " is " + m.getOut());
        s.close();
    }   
}   
