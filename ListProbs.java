package DS;

public class ListProbs {
	/*
	 *  Iterate trough the linked list. 
	 *  In loop, change next to prev, prev to current and current to next.
	 *  Time Complexity: O(n)
		Space Complexity: O(1)
		a-->b-->c-->d
		a<--b<--c<--d
	 */
	public void reverse(Node head){
		
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
			System.out.println(rest.data);
			
		return rest;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLinkedList ll = new SLinkedList();
		ll.insertDummy(5);
		ListProbs probs =  new ListProbs();
		ll.print("Before");
		ll.head = probs.recursiveReverse(ll.head);
		ll.print("Reversed");
		
		
		

	}

}
