package DS;

public class Queue {
	private int capacity;
	private int arr[];
	private int front = 0;
	private int rear = 0;
	private int count = 0;
	
	public  Queue(int capacity){
		arr = new int[capacity];
		this.capacity = capacity;
		
	}
	
	public void push(int item){
		if (count >= capacity){
			expandQ();
		}
			arr[rear] = item;
			rear  = (rear +1) % capacity;
			count++;
		
	}
	public int pop(){
		Integer item = null;
		if (count != 0){
			item = arr[front];
			front  = (front +1) % capacity;
			count --;
		}else{
			System.out.println("Empty Queue");	
		}
		return item;
	}
	private void expandQ(){
		int bigArr[] =  new int[capacity*2];
		for (int i =0;i<count;i++){
			bigArr[i]=arr[front];			    
			front = (front+1)%capacity;
			
		}
		capacity = capacity*2;
		front = 0;
		rear = count;
		arr = bigArr;
	}
	public void print(){
			for (int i = 1; i < count; i++) { 
			    System.out.print(arr[(front+i)%capacity]+" ");  
			   }  
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue Q = new Queue(10);

		for (int i=0;i<50;i++){
			Q.push(i);
			
		}
		Q.pop();
		Q.pop();
		Q.pop();
		Q.pop();
		Q.pop();
		Q.pop();
		Q.pop();
		for (int i=100;i<290;i++){
			Q.push(i);
			
		}
		Q.pop();
		Q.pop();
		Q.pop();
		for (int i=100;i<290;i++){
			Q.push(i);
			
		}
		Q.print();
		
		
	}

}
