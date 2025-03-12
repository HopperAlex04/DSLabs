public class BSTtest 
{
    public static void main(String args[])
    {
        Request req = new Request('a', 10);
        BST bst = new BST();
        bst.insert(20, req);
        bst.insert(9, req);
        bst.insert(21, req);
        bst.print();
        bst.delete(9);
        bst.delete(20);
        bst.print();
    }
}
