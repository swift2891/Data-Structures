class Node{
	int data;
	Node next;
	public Node(int val){
		data = val;
	}
}

public class MyQueue{
	Node head, tail;
	public MyQueue(int val){
		head = tail = new Node(val);
	}

	public void enqueue(int val){
		Node t = new Node(val);
		tail.next = t;
		tail = t;
	}

	public int dequeue(){
		int res = head.data;
		head = head.next;	
		return res;
	}

	public static void main(String[] args){
		MyQueue q = new MyQueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());	
		System.out.println(q.dequeue());	
	}
}