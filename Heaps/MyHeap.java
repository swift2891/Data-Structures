//Min_Heap example
public class MyHeap{
	int[] heap;
	int index,ptr;
	public MyHeap(int v){
		heap = new int[v];
	}
	public void swap(int a,int b){
		int t = heap[a];
		heap[a] = heap[b];
		heap[b] = t;
	}

	public void insert(int v){
		heap[index] = v;
		ptr = index;
		while(true){
			int parent = (ptr/2) - 1 + (ptr%2);
			if(parent<0)
				parent=0;
			if(ptr == parent)
				break;
			if(heap[ptr] > heap[parent]){
				break;
			}
			else{
				swap(ptr,parent);
				ptr = parent;
			}
		}
		index+=1;
	}

	public int extract(){
		int res = heap[0];
		heap[0] = heap[index-1];
		System.out.println("heap[0]:" + heap[0]);
		heap[index-1] = 0;
		ptr = 0;
		index -= 1;
		
		int child1, child2;
		while(ptr<index-1){
			child1 = (ptr * 2) + 1;
			child2 = (ptr * 2) + 2;
			if(ptr == child1)
				break;
			if(heap[ptr]>heap[child1]){
				swap(ptr,child1);
				ptr = child1;
			}
			else if(heap[ptr]>heap[child2]){
				swap(ptr,child2);
				ptr = child2;
			}
			else{
				break;
			}
		}
		return res;	
	}
	
	public static void main(String[] args){
		MyHeap mh = new MyHeap(20);
		mh.insert(10);
		mh.insert(5);
		mh.insert(8);
		mh.insert(6);
		mh.insert(1);
		mh.insert(7);
		for(int i:mh.heap)
			System.out.println(i+" ");

		System.out.println(mh.extract());
		System.out.println("After extract");
		for(int i:mh.heap)
			System.out.println(i+" ");


	}
}