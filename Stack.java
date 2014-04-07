package DS;

public class Stack {
	private int capacity=10;
	private int size=-1;
	private int arr[];
	public Stack(){
		arr =  new int[capacity];
	}
	public Stack(int capacity){
		arr =  new int[capacity];
		this.capacity = capacity;
	}
	
	public void push(int item){
		if (size++ <= capacity){
			
			expand();
		}
		arr[size]=item;
	}
	public Integer pop(){
		if (size == -1){
			System.out.println("Empty Stack");
			return null;
		}
		int pitem = arr[size];
		size --;
		return pitem;
	}
	public void print(){
		for (int i=0;i<=size;i++){
			System.out.print(" "+arr[i]);
		}
	}
	private void expand(){
		int larr[] = new int[capacity*2];
		for (int i=0;i<size;i++){
			larr[i]=arr[i];
		}
		arr = larr;
		capacity = capacity *2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack S = new Stack(3);
		S.push(10);
		S.push(20);
		S.push(30);
	//	System.out.print("S.pop():"+S.pop());
		S.push(40);
		S.push(40);
		S.print();
		
		

	}

}
