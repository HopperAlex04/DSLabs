public class BST
{
	private Node root;

	public BST()
	{
	}
	
	public void insert(int time, Request req)
	{
		root = insert(root, time, req);
	}

	private Node insert(Node tree, int time, Request req)
	{
		if (tree == null) 
		{
			return new Node(time, req);
		}
		if (time < tree.time)
		{
			tree.left = insert(tree.left, time, req);
		} 
		else if (time > tree.time)
		{
			tree.right = insert(tree.right, time, req);
		}
		return tree;
	}

	public Node pred(int time)
	{
		return pred(root, time, null);
	}

	private Node pred(Node tree, int time, Node rightStep)
	{
		//Left Child
		if (tree == null)
		{
			return rightStep;
		}
		if (time < tree.time)
		{
			return pred(tree.left, time, rightStep);
		}
		if (time > tree.time)
		{
			rightStep = tree;
			return pred(tree.right, time, rightStep); 
		}
		if (time == tree.time)
		{
			if (tree.left != null)
			{
				return max(tree.left);
			}
		}
		return rightStep;
	}

	public Node succ(int time)
	{
		return succ(root, time, null);
	}

	private Node succ(Node tree, int time, Node leftStep)
	{
		if (tree == null)
		{
			return leftStep;
		}
		if (time < tree.time)
		{
			leftStep = tree;
			return succ(tree.left, time, leftStep);
		}
		if (time > tree.time)
		{
			return succ(tree.right, time, leftStep); 
		}
		if (time == tree.time)
		{
			if (tree.right != null)
			{
				return min(tree.right);
			}
		}
		return leftStep;
	}

	public Node min()
	{
		return min(root);
	}

	private Node min(Node tree)
	{
		Node min = tree;
		if (tree != null && tree.left != null)
		{
			min = min(tree.left);
		}
		return min;
	}

	public Node max()
	{
		return max(root);
	}

	private Node max(Node tree)
	{
		Node max = tree;
		if (tree != null && tree.right != null)
		{
			max = max(tree.right);
		}
		return max;
	}

	public void delete(int time)
	{
		root = delete(root, time);
	}

	public Node delete(Node tree, int time)
	{
		if (tree == null)
		{
			return tree;
		}
		if (tree.time > time)
		{
			tree.left = delete(tree.left, time);
		}
		else if (tree.time < time)
		{
			tree.right = delete(tree.right, time);
		}
		else 
		{
			if (tree.left == null)
			{
				return tree.right;
			}	
			if (tree.right == null)
			{
				return tree.left;
			}
			Node succNode = succ(time);
			tree.time = succNode.time;
			tree.req = succNode.req;
			tree.right = delete(tree.right, succNode.time);
		}
		return tree;
	}

	public void print()
	{
		print(root);
	}

	private void print (Node tree)
	{
		if (tree == null)
		{
			return;
		}
		print(tree.left);
		System.out.println(tree);
		print(tree.right);
	}
}
