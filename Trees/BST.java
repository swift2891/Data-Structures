class Node{
	int data;
	Node left,right;
	public Node(int val){
		data = val;
	}
}

public class BST{
	Node root;
	public BST(int val){
		root = new Node(val);
	}

	public void add(int v){
		Node c = this.root;
		while(true){
			if(v<c.data){
				if(c.left!=null){
					c = c.left;
				}
				else{
					c.left = new Node(v);
					break;
				}	
			}
			else{
				if(c.right!=null){
					c = c.right;
				}
				else{
					c.right = new Node(v);
					break;
				}
			}
		}	
	}

	public static void inOrderTraverse(Node n){
		Node c = n;
		
		if(c.left!=null && c.right!=null){
			inOrderTraverse(c.left);
			System.out.println(c.data);
			inOrderTraverse(c.right);
		}
		else if(c.left!=null){
			inOrderTraverse(c.left);
			System.out.println(c.data);
		}
		else if(c.right!=null){
			System.out.println(c.data);
			inOrderTraverse(c.right);	
		}
		else{
			System.out.println(c.data);
		}
	}

	public static void preOrderTraverse(Node n){
		Node c = n;
		
		if(c.left!=null && c.right!=null){
			System.out.println(c.data);
			preOrderTraverse(c.left);
			preOrderTraverse(c.right);
		}
		else if(c.left!=null){
			System.out.println(c.data);
			preOrderTraverse(c.left);
		}
		else if(c.right!=null){
			System.out.println(c.data);
			preOrderTraverse(c.right);	
		}
		else{
			System.out.println(c.data);
		}
	}

	public static void postOrderTraverse(Node n){
		Node c = n;
		
		if(c.left!=null && c.right!=null){
			postOrderTraverse(c.left);
			postOrderTraverse(c.right);
			System.out.println(c.data);
		}
		else if(c.left!=null){
			postOrderTraverse(c.left);
			System.out.println(c.data);
		}
		else if(c.right!=null){
			postOrderTraverse(c.right);
			System.out.println(c.data);	
		}
		else{
			System.out.println(c.data);
		}
	}

	public static void main(String args[]){
		BST bst = new BST(5);
		bst.add(3);
		bst.add(1);
		bst.add(2);
		bst.add(7);
		bst.add(6);
		bst.add(8);
		bst.add(9);
		bst.add(4);
//		inOrderTraverse(bst.root);
//		preOrderTraverse(bst.root);
		postOrderTraverse(bst.root);
	}
}










