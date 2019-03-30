import java.util.*;

class Node<T, U>{
	T key;
	U value;
	public Node(){
		this.key = null;
		this.value = null;
	}
	public Node(T key, U value){
		this.key = key;
		this.value = value;
	}
}	

class HashT<T,U>{
	Node<T, U> node;
	List<LinkedList<Node>> mainList;
	public HashT(){
		System.out.println("Initializing array");
		mainList = new ArrayList<LinkedList<Node>>(15);
	}
	public HashT(int size){
		System.out.println("Initializing LL array with custom size");
		mainList = new ArrayList<LinkedList<Node>>(size);
	}
	
}

public class HashTable{

	public static void main(String[] args){
		HashT<Integer,Integer> ht = new HashT<Integer,Integer>(); 
	}
	
}