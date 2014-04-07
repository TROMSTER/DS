import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Arrays;



class Node {
	int data;
	Node next;
	public Node(int item){
		data = item;
		next = null;
	}
	public void setData(int item){
		data = item;
		
	}
	public void print(){
		System.out.print(data);
	}
}

public class SLinkedList {
	Node head;
	private int length = 0;
	private Node current;
	public SLinkedList(int item){
		head = new Node(item);
	}
	public SLinkedList(){
		head = null;
	}
	public void appendLast(int item){
		 
		Node currentNode = head;
		Node newNode = new Node(item);
		if (head == null){
			head = newNode;
					
		}else{
			while( currentNode != null && currentNode.next != null ){
				currentNode= currentNode.next;
			}
			currentNode.next=newNode;
		}
		length ++;
	}
		
	public void appendFirst(int item){
		

		Node newNode = new Node(item);
		newNode.next = head;
		head = newNode;
		length ++;
	}
	public void appendPosition(int item,int index){
		Node currentNode = head;
		
		int i =1;
		
		while( currentNode != null && currentNode.next != null && i < index ){
			currentNode= currentNode.next;
			i++;
		}
		
		if (i == index ){
			Node newNode = new Node(item);
			Node temp = currentNode.next;
			currentNode.next= newNode;
			newNode.next = temp;
			length ++;
		}
		
	}
	public void print(String... message){
		Node currentNode = head;	
		System.out.println(Arrays.toString(message).replace("[", "").replace("]", ""));
		while(currentNode != null){
			System.out.print(currentNode.data);
			currentNode= currentNode.next;
			if (currentNode != null){
				System.out.print("-->");
			}
			
		}
		System.out.print("\n");
	}
	public void print(Node curNode,String... message){
		Node currentNode = curNode;	
		System.out.println(Arrays.toString(message).replace("[", "").replace("]", ""));
		while(currentNode != null){
			System.out.print(currentNode.data);
			currentNode= currentNode.next;
			if (currentNode != null){
				System.out.print("-->");
			}
			
		}
		System.out.print("\n");
	}
	public void insertDummy(int max){
		for (int i=max;i>0;i--){
			appendFirst(i);
		}
		
	}
	public int length(){
		return length;
	}
	/*
	 *  Iterate trough the linked list. 
	 *  In loop, change next to prev, prev to current and current to next.
	 *  Time Complexity: O(n)
		Space Complexity: O(1)
		a-->b-->c-->d
		a<--b<--c<--d
	 */
	public void reverse(){
		
		Node current = head;
		Node next = null;
		Node prev = null;
		while (current != null){
			next = current.next;
			current.next = prev;
			prev=current;
			current = next;
		}
		head = prev;
		
	}
	/*
	 *  1) Divide the list in two parts - first node and rest of the linked list.
   	 *	2) Call reverse for the rest of the linked list.
   	 *	3) Link rest to first.
   	 *  4) Fix head pointer
   	 *  Time Complexity: O(n)
		Space Complexity: O(1)
		Its wrong !!!!!!! need to fix this
	 */
	public Node recursiveReverse(Node head){
		//System.out.println(head.data);
		Node first = head;
			
		Node rest = first.next;
		 /* List has only one node */
		if (rest == null){
			return first;
		}
		/* reverse the rest list and put the first element at the end */
			recursiveReverse(rest);
			rest.next =first;
			first.next  = null;
			
		return rest;
		
	}
	public Node getNth(int index){
		Node current = head;
		int i=0;
		while (current !=null && i < index ){
			current=current.next;
			i++;
			
		}
		System.out.println(i);
		if ( i == index ){
			return current;
		}
		
		return null;
				
		
		
	}
	public int count(){
		current = head;
		int i = 1;
		while(current.next != null){
			current=current.next;
			i++;
					
		}
		return i;
	}
	public Node pop(){
		
		Node current = head;
		head = current.next;
		return current;
				
	}
	/**
	 * Merge two linked list into one on sorted manner
	 * @param a
	 * @param b
	 * @return
	 */
	private  Node sortedMerge(Node a, Node b){
		Node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data <= b.data){
			result = a;
			result.next = sortedMerge(a.next, b);
		}else{
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
		
	}
	/*
	 * http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
	 */
	public ArrayList<Node> splitHalf(Node head,int length){
		//System.out.println("Lenght"+length);
		ArrayList<Node> heads = new ArrayList<Node>();
		heads.add(head);
		if (head == null || head.next == null){
			 
			 heads.add(null);
			 return heads;
		}
		current = head;
		int i =1;
		Node prev=current;
		while(current != null && i<= (length/2)){
			prev=current;
			current = current.next;
			i++;
		}
		SLinkedList s = new SLinkedList();
		s.head=head;
		//s.print("split");
		heads.add(current);
		prev.next=null;
		return heads;
			
	}
	public Node MergeSort(Node head,int length){
		
		if (head == null || head.next==null){
			return head;
		}
		ArrayList<Node>  heads =splitHalf(head,length);
		SLinkedList templist=new SLinkedList();
		templist.head = heads.get(0);
		//templist.print("Templist");
		//templist.print("Templist"+templist.count());

		MergeSort(templist.head, templist.count());
		templist.head = heads.get(1);
		MergeSort(templist.head, templist.count());
		templist.print("dddd>>");
		return sortedMerge(heads.get(0), heads.get(1));
		
	}
		
	//public MergeSort(Node a.Node b)
	public static void main(String[] args) {
		SLinkedList list  = new SLinkedList(10);
		list.insertDummy(5);
		System.out.println("Count"+list.count());
		list.count();
		//list.print();
		list.appendPosition(100,5);
		//list.print();
		list.appendLast(500);
		list.reverse();
		//list.print();
		list.appendFirst(980);
		list.appendFirst(67);
		SLinkedList list2  = new SLinkedList();
		list2.insertDummy(5);
		list2.appendFirst(45);
		list2.appendPosition(23, 3);
		//list2.print("second");
		//Node result = list.sortedMerge(list.head, list2.head);
		list.print("Full");
		//SLinkedList temp  = new SLinkedList();
		//temp.insertDummy(2);
		//temp.print("temp");
		//ArrayList<Node>  heads = list.splitHalf(temp.head,temp.length);
		//temp.print(heads.get(0),"first..");
		//temp.print(heads.get(1),"next..");
		//list2.print(heads.get(0),"Split First Part");
		//list2.print(heads.get(1),"Split second Part");
		Node head = list.MergeSort(list.head,list.count());
		list.print(head,"After Sort");
		
		
		
		
		
		
	
		
		
	}

}
