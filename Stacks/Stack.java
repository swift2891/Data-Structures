//A basic Stack Implemetation
//No Out of Bound cases handeled.

public class Stack{

	private int pointer;
	private int[] stackArray;
	public Stack(int arraySize){
		stackArray = new int[arraySize];
		pointer = -1;
	}
	public Stack(){
		//default size
		int[] stackArray = new int[100];	
		pointer = -1;
	}

	public void push(int newItem){
		pointer += 1;
		stackArray[pointer] = newItem;
	}

	public int pop(){
		int currentItem = stackArray[pointer];
		pointer -= 1;
		return currentItem;
	}

	public static void main(String args[]){

		Stack s = new Stack(10);
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}