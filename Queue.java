package DS;

public class Queue {
	int capacity;
	int arr[];
	int front = 0;
	int rear = 0;
	int count = 0;
	
	public  Queue(int capacity){
		arr = new int[capacity];
		this.capacity = capacity;
		
	}
	public void push(int item){
		if (count< capacity){
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
			System.out.println("item "+item);	
			front  = (front +1) % capacity;
			count --;
		}else{
			System.out.println("Empty Queue");	
		}
		return item;
	}
	public void expandQ(){
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
			for (int i = 0; i < count; i++) { 
			    System.out.print(arr[(front+i)%capacity]+" ");  
			   }  
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue Q = new Queue(5);
		Q.push(1);
		Q.push(2);
		Q.push(3);
		Q.push(4);
		Q.print();
		Q.pop();
		Q.print();
		Q.push(5);
		Q.pop();
		Q.push(6);
		Q.push(7);
		Q.push(8);
		for (int i=0;i<10;i++){
			Q.push(i*20);
		}
		Q.print();
		
		
	}

}
