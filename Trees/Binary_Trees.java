class Node{
	int data;
	Node left, right;
	public Node(int val){
		data = val;
	}
}

class Binary_Search_Tree{
	Node root;
	public Trees(int val){
		root = new Node(val);
	}
	
	public addNode(int val){
		Node current = head;
		while(current != null){
			if(current.data < val){
				if(current.right!=null)
					current = current.right;
				else{
					current.right = new Node(val);
					break;
				}
			}
			else{
				if(current.left != null)
					current = current.left;
				else{
					current.left = new Node(val);
					break;
				}
			}
		}
	}	

	public inOrderTraverse(Node head){

	}
}

public class Binary_Trees{
	public static void main(){
		Binary_Search_Tree bst = new Binary_Search_Tree(1);
		bst.addNode(2);
		bst.addNode(0);
		bst.addNode(3);
		
	}
}

