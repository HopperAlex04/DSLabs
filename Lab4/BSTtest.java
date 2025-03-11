public class BSTtest 
{
    public static void main(String args[])
    {
        Request req = new Request('a', 10);
        BST bst = new BST();
        bst.insert(20, req);
        bst.insert(11, req);
        bst.insert(9, req);
        bst.insert(25, req);
        bst.insert(23, req);
        bst.insert(26, req);
        bst.insert(10, req);
        bst.print();
    }
}
