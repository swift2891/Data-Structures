class Node{
	int data;
	Node next;
	public Node(int val){
		data = val;
	}
}

public class MyStack{
	Node top;
	public MyStack(int val){
		top = new Node(val);
	}

	public void push(int val){
		Node t = top;
		top = new Node(val);
		top.next = t;
	}

	public int pop(){
		int res;
			res = top.data;
			top = top.next;		
			return res;
	}

	public static void main(String[] args){	
		MyStack stack = new MyStack(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}






