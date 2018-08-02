class Node{
	int data;
	Node next;
	public Node(int val){
		data = val;
	}
}

public class SetOfStacks{
	Node[] set; Node top;
	int count=0, index=0;	
	public SetOfStacks(int val){
		set = new Node[val];
	}
	
	public void push(int val){
		if(count==3){
			count=0;
			index+=1;
		}
			
		if(set[index]!=null){
			Node t = set[index];
			set[index] = new Node(val);
			set[index].next = t;
			count++;
			
		}
		else{
			set[index] = new Node(val);
			count++;
		}
	}

	public int pop(){
		int res = set[index].data;
		if(set[index].next!=null){
			set[index] = set[index].next;
			count -=  1;
		}
		else{
			set[index] = null;
			index -= 1;
			count = 3;
		}
		return res;
	}
	
	public static void main(String[] args){
		SetOfStacks s = new SetOfStacks(5);
		s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);
		System.out.println(s.pop()+"  "+s.pop()+"  "+s.pop()+"  "+s.pop()+"  "+s.pop());
	}
}