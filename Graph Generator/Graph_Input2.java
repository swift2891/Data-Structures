import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

/*
To Do's:

*/
public class Graph_Input2{
	private static File fi = new File("input.txt");
	private static int Vertices, EdgesCount, weight, weightRandom, edgeVertex[], edgeVertex1, edgeVertex2;
	private static Random rand = new Random(100);
	private static Random rand2 = new Random();
	private static HashSet<Integer> hashRandom = new HashSet<Integer>();
	private static Hashtable<Integer,List<Integer>> hashEdges = new Hashtable<Integer,List<Integer>>();
	private static String edgeWtString;
	private static boolean c1, c2;
	private static List<Integer> hashValList, finalHashList; 

	public static int computeWeight(){
		weightRandom = rand.nextInt(EdgesCount*2);
		weightRandom = hashRandom.add(weightRandom)?weightRandom:computeWeight();
		return weightRandom;
	}

	public static boolean checkHashVal(int xKey, int yValue){
		if(hashEdges.get(xKey)!=null){
			hashValList = hashEdges.get(xKey);
			if(hashValList.contains(yValue))
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public static int[] computeEdges(){
		//Eliminate Self Loop Edges 0 to 0:
		edgeVertex1 = rand.nextInt(Vertices);
		edgeVertex2 = rand.nextInt(Vertices);
		//In a (u,v) u cannot be equal to v:
		while(edgeVertex1==edgeVertex2){
			edgeVertex1 = rand.nextInt(Vertices);
			edgeVertex2 = rand.nextInt(Vertices);
			// System.out.println("Recomputing randoms ..\n");
		}
		c1 = hashEdges.containsKey(edgeVertex1) && checkHashVal(edgeVertex1,edgeVertex2);
		c2 = hashEdges.containsKey(edgeVertex2) && checkHashVal(edgeVertex2,edgeVertex1);
		if(c1 || c2){
			// System.out.println("detecting duplicate edge\n");
			return computeEdges();
		}
		else {
			if(hashEdges.get(edgeVertex1)!=null){
				finalHashList = hashEdges.get(edgeVertex1);
				finalHashList.add(edgeVertex2);
			}
			else{
				finalHashList = new ArrayList<Integer>();
				finalHashList.add(edgeVertex2);	
			}
			hashEdges.put(edgeVertex1,finalHashList);
			edgeVertex[0] = edgeVertex1;
			edgeVertex[1] = edgeVertex2;
			return edgeVertex;
		}

	}

	public static void main(String[] args){
		edgeVertex = new int[2];
		Vertices = Integer.parseInt(args[0]);
		EdgesCount = Integer.parseInt(args[1]);
		if(EdgesCount > (Vertices*(Vertices-1)/2))
			EdgesCount = Vertices*Vertices-1/2;
		try{
			PrintWriter output = new PrintWriter(fi);			
			output.println(Vertices);
			
			//printing edges and weights
			for(int i=0;i<EdgesCount;i++){						
				weight = computeWeight();
				edgeVertex = computeEdges();
				edgeWtString = edgeVertex[0]+" "+edgeVertex[1]+" "+weight;
				output.println(edgeWtString);				
			}	
			output.close();
		}
		catch(Exception e){
			// System.out.println("Some Exception detected: "+ e +"\n");
			e.printStackTrace();
			// throw new Exception("EXCEPTION" + e.getMessage(), e);
		}	
	}
}