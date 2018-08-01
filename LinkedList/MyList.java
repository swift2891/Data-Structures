import java.util.*;
 
class Node{
	int data;
	Node next;
	public Node(int val){
		data = val;
	}
}

public class MyList{
	Node root;

	public MyList(int val){
		root = new Node(val);
	}

	public void addNode(int val){
		Node current = this.root;
		for(Node i=this.root; i.next != null; i=i.next, current=i);
		current.next = new Node(val);
	}

	public void printNodes(){
		System.out.println("Input List:");
		for(Node i=this.root;i!=null;i=i.next)
			System.out.println(i.data);
	}

	public void printNodes2(Node head){
		for(Node i=head;i!=null;i=i.next)
			System.out.println(i.data);
	}

	public Node reverseList(){
		Node current = this.root;
		Node nextNode, prevNode;

		prevNode = current;
		nextNode = current.next;		
		current.next = null;

		while(nextNode!=null){
			current = nextNode;
			nextNode = nextNode.next;
			current.next = prevNode;
			prevNode = current;
		}
		return current;
		
	}

	public void createLoop(){
		Node last = this.root;int cnt=0;Node temp=this.root;
		for(Node i = this.root; i.next!=null; i=i.next,cnt++,last=i){
			if(cnt==2){
				temp = i;
			}
		}
		last.next = temp;			
	}
	
	public void checkLoop(){
		Hashtable<Node,Node> ht = new Hashtable<Node, Node>();
		Node retNode=new Node(0);
		for(Node i = this.root;i!=null;i=i.next){
			retNode = ht.put(i,i);
			if(retNode != null){
				if(retNode.equals(i)){
					System.out.println("Duplicate Detected: "+i.data);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args){
		MyList list = new MyList(1);
		//Add
		list.addNode(2);
		list.addNode(4);
		list.addNode(7);
		list.addNode(8);
		
		//System.out.println("Root Object:"+list.root.hashCode()+"  "+list.root.next.hashCode());	

		//Print
		list.printNodes();
		
		//Reverse
		//System.out.println("Reversed List:");
		//list.printNodes2(list.reverseList());

		//Identify Loop (Using HT?)
		list.createLoop();
		list.checkLoop();
		

	}
}
