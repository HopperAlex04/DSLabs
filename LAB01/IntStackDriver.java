public class IntStackDriver 
{
    public static void main(String args[])
    {
        IntStack p = new IntStack();
        for (int i = 0; i < 30; i++)
        {
            System.out.print(p.getTop()+ " "); 
            p.push(i);
        }
        System.out.println();
        for (int i = 0; i < 30; i++)
        {
            System.out.print(p.pop() + " "); 
        }


    }    
}
