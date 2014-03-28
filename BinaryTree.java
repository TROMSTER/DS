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
			inorder(root.left);
			inorder(root.right);
		}
	
	}
	public void postorder(BNode root){
		if (root != null){
			inorder(root.left);
			inorder(root.right);
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
		System.out.println(root.data+","+data);
		if ((root.right !=null && root.right.data == data) || (root.left != null && root.left.data == data))
				return root;
		if (root.data > data)
			return findParentNode(data,root.left);
		else if (root.data < data)
			return findParentNode(data,root.right);

		return null;

	}
	public void delete(BNode root,BNode node){
	if (node.left == null && node.right == null){
		if (node.data < root.data){
			delete(root.left,node);
		}else{
			delete(root.left,node);
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
		BNode f = btree.findParentNode(15,btree.head);
		System.out.println("Find "+f.data);
		btree.inorder(btree.head);
		//btree.preorder(btree.head);
		//btree.postorder(btree.head);
		BNode s =  new BNode();
		s.data = 1;
		//System.out.println(btree.binarySearch(btree.head,s));
		//System.out.println(btree.maxDepth(btree.head));
		Stack<BNode> stack = new Stack<BNode>();
		//btree.allPathSum(btree.head,stack);
		
		
		//[1 2 4 5 6 7,12]
	}

}
