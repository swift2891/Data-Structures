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
	
	public Node[] findNode(int val){
		Node[] res = new Node[2];
		Node prevNode=this.root,c = this.root;
		while(true){
			if(val<c.data){
				if(c.left!=null){
					prevNode = c;
					c = c.left;
				}
				else{
					return null;
				}
			}
			else if(val>c.data){
				if(c.right!=null){
					System.out.println("Right side>>");
					prevNode = c;
					c = c.right;
				}
				else{
					return null;
				}
			}
			else{
				System.out.println("Found Ya");
				res[0] = c;
				res[1] = prevNode;
				return res;
			}
		}	
	}
		
	public Node findSuccessor(Node n){
		Node c = n;
		while(true){
			if(c.right!=null){
				c = c.right;
				while(c.left!=null){
					c = c.left;
				}
				return c;
			}
			else{
				return c;
			}
		}	
	}
	
	public void delete(int val){
		Node[] t = findNode(val);
		System.out.println("Node details:"+t[0].data+" parent:"+t[1].data);
		if(t[0].left!=null && t[0].right!=null){
			Node s = findSuccessor(t[0]);
			int temp = s.data;
			delete(s.data);
			t[0].data = temp;
		}
		else if(t[0].left!=null){
			if(t[1].left == t[0])
				t[1].left = t[0].left;
			else
				t[1].right = t[0].left;
		}
		else if(t[0].right!=null){
			if(t[1].left == t[0])
				t[1].left = t[0].right;
			else
				t[1].right = t[0].right;
		}
		else{
			System.out.println("Leaf delete:"+t[0].data);
			if(t[1].left == t[0])	
				t[1].left = null;
			else
				t[1].right = null;
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
//		postOrderTraverse(bst.root);
		inOrderTraverse(bst.root);
		bst.delete(5);
		System.out.println("After deleting");
		inOrderTraverse(bst.root);
//		Node a[] = bst.findNode(8);
//		System.out.println(a[0].data+" "+a[1].data);
		//System.out.println(bst.findSuccessor(bst.root.left.right).data);
	}
}










