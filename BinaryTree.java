package DS;

import java.util.Stack;

class BNode{
	Integer data;
	BNode left;
	BNode right;
	BNode(){
		data = null;
		left =null;
		right = null;
	}
	
}
public class BinaryTree {
	BNode head;
	public void insert(int item){
		BNode current = head;
		
		BNode newNode = new BNode();
		newNode.data = item;
		if (head == null){
			head = newNode;
			return;
		}
		
		while (current != null){
			if (current.data >=	 item){
				if (current.left == null){
					current.left = newNode;
					return;
				}else {
					current=current.left;
				}
				
			}else if (current.data < item){
				if ( current.right == null){
					current.right = newNode;
					return;
				}else {
					current = current.right;
				}
			}
		}
	}
	public void inorder(BNode root){
		if (root != null){
			inorder(root.left);
			System.out.println(" "+root.data);
			inorder(root.right);
			
		}
	}
	public void preorder(BNode root){
		if (root != null){
			System.out.println(" "+root.data);
			preorder(root.left);
			preorder(root.right);
		}
	
	}
	public void postorder(BNode root){
		if (root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.println(" "+root.data);
			
		}
	
	}
	public boolean binarySearch(BNode root,BNode n){
		if (root == null || n == null){
			return false;
		}
		System.out.println("  Testing out "+root.data+" for value "+n.data);
		if (root.data <= n.data){
			return binarySearch(root.left,n);
		}else if (root.data > n.data){
			return binarySearch(root.right, n);
		}
		return true;
	}
	public int size(BNode root){
		if (root == null)
			return 0;
		else{
			return size(root.left)+1+size(root.right);
		}
				
	}
	public int maxDepth(BNode root){
		if (root == null){
			return 0;
		}
		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);
		System.out.println("lDepth:"+lDepth+" rDepth:"+rDepth);
		if (lDepth > rDepth)
			return lDepth + 1;
		else 
			return rDepth + 1;
	}
	/*
	 * Print all path along with sum
	 */
	
	public void allPathSum(BNode root,Stack<BNode> s){
		
		if (root == null){
			return;
			
		}
		s.add(root);
		if (root.left == null && root.right == null){
			int sum =0;
			for (BNode node : s){
				System.out.print(node.data+" + ");
				sum =sum+node.data;
			}
			System.out.print(" = "+(sum)+" \n");
			
			
		}
		
		allPathSum(root.left,s);
		allPathSum(root.right,s);
		s.pop();
	}
	public void mirror(BNode root){
		BNode temp = root.left;
	}
	public int height(BNode root){
		if (root == null){
			return 0;
		}
		return 1+ Math.max(height(root.left),height(root.right));
	}
	public BNode findNode(int data, BNode root){
		if (root == null)
			return null;
		System.out.println(root.data+","+data);
		if (root.data == data)
				return root;
		if (root.data > data)
			return findNode(data,root.left);
		else if (root.data < data)
			return findNode(data,root.right);

		return null;

	}
	public BNode findParentNode(int data, BNode root){
		if (root == null)
			return null;
		if ((root.right !=null && root.right.data == data) || (root.left != null && root.left.data == data))
				return root;
		if (root.data > data)
			return findParentNode(data,root.left);
		else if (root.data < data)
			return findParentNode(data,root.right);

		return null;

	}
	public BNode findMinimum(BNode root){
		BNode currentNode = root;
		while (currentNode.left != null ){
			currentNode = currentNode.left;
		}
		return currentNode;
	}
	public void setChild(BNode parent, BNode child){
		if (child != null){
			if (parent.left.data < child.data)
				parent.left = child;
			else
				parent.right = child;
		}
	}
	
	public void delete(BNode root,int data){
	System.out.println(root.data+","+data);

	//Bnode dnode = findNode(data, root);
	BNode parent = findParentNode(data,root);
	BNode dnode = parent.left.data == data? parent.left:parent.right;
	BNode newParentChild =null;
	//Case 1: Current is the node we want to delete
	
	if (dnode.left == null && dnode.right ==null){
		
		if (parent.left.data == data)
			parent.left = null;
		else
			parent.right = null;

	}else if ( dnode.left == null || dnode.right ==null){ //Case 2: Node has either left or right child 
		
		if (dnode.left != null)
			newParentChild = dnode.left;
		else
			newParentChild = dnode.right;
		setChild(parent,newParentChild);
		
	}else {//Case 3: node has right and left child: will replace with smallest element of the right subtree
		BNode min = findMinimum(dnode.right);
		delete(dnode.right,min.data);
		min.left=dnode.left;
		min.right=dnode.right;
		setChild(parent,min);
	}

}
	private void PrintSpace(int n)
	{
	  for (int i = 0; i < n; ++i)
	    System.out.print(" ");
	}
	private void PrintTree(BNode root, int level)
	{
	  if (root== null) return;

	  PrintSpace(level * 2);
	  System.out.print(root.data);
	  System.out.print("\n");
	  PrintTree(root.left, level - 1);
	  System.out.print(" ");
	  PrintTree(root.right, level - 1);
	}
	public void print(BNode root){
		int height = height(root);
		PrintTree(head,height);
	}
	public void levelorder(BNode root){
		for (int d =1;d<=height(root);d++){
			 System.out.print("\n");
			 for (int i =d;i<=height(root);i++){
				 System.out.print("  ");
			 }
			 System.out.println("/");
		 printGivenLevel(root, d);
		}
	}
	private void printGivenLevel(BNode root, int level){
		if (root ==null) return;
		if (level ==1){
			System.out.print(" "+root.data);
		}else if(level > 1){
			
		    printGivenLevel(root.left, level-1);
		    if (root.left !=null){
				System.out.print("   ");
			}
		    printGivenLevel(root.right, level-1);
		    if (root.right !=null){
				System.out.print("   ");
			}

		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree btree = new BinaryTree();
		btree.insert(8);
		btree.insert(10);
		btree.insert(4);
		btree.insert(6);
		btree.insert(3);
		btree.insert(5);
		btree.insert(9);
		btree.insert(15);
		btree.insert(11);
		btree.insert(201);
		btree.insert(14);
		//btree.print(btree.head);
		//BNode f = btree.findParentNode(4,btree.head);
		//btree.inorder(btree.head);
		//btree.delete(btree.head , 4);
		//btree.height(btree.head);
		//btree.preorder(btree.head);
		//btree.postorder(btree.head);
		BNode s =  new BNode();
		s.data = 1;
		//System.out.println(btree.binarySearch(btree.head,s));
		//System.out.println(btree.maxDepth(btree.head));
	//	Stack<BNode> stack = new Stack<BNode>();
		//btree.allPathSum(btree.head,stack);
		//System.out.println(btree.height(btree.head));
		
		//[1 2 4 5 6 7,12]
		btree.levelorder(btree.head);
	}

}
