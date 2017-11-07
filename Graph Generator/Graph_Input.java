import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.HashSet;
import java.util.Hashtable;
/*
To Do:
Update List notation everywhere
new way to get and put from list
iterate throu list for searching values.

*/
public class Graph_Input{
	private static File fi = new File("input.txt");
	private static int Vertices, EdgesCount, weight, weightRandom, edgeVertex[], edgeVertex1, edgeVertex2;
	private static Random rand = new Random(100);
	private static Random rand2 = new Random();
	private static HashSet<Integer> hashRandom = new HashSet<Integer>();
	// private static HashSet<Integer> hashEdges = new HashSet<Integer>();
	private static Hashtable<Integer,List<Integer>> hashEdges = new Hashtable<Integer,List<Integer>>();
	private static String edgeWtString;
	private static boolean c1, c2;
	
	public static int computeWeight(){
		weightRandom = rand.nextInt(EdgesCount*10);
		weightRandom = hashRandom.add(weightRandom)?weightRandom:computeWeight();
		return weightRandom;
	}
	public static boolean checkHashVal(){

		System.out.println("checkhash: "+hashEdges.get(edgeVertex1)+"\n");

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
			System.out.println("Executing while loop ..\n");
		}
		System.out.println("u: "+edgeVertex1+" v: "+edgeVertex2+"\n");
		c1 = hashEdges.containsKey(edgeVertex1) && checkHashVal(); //----------------------
		
		int b = edgeVertex2, a=1212121;
		boolean s11= hashEdges.containsKey(edgeVertex1);
		boolean s12 = false;
		if(hashEdges.get(edgeVertex1)!=null){
			s12 = (hashEdges.get(edgeVertex1) == edgeVertex2);
			a = hashEdges.get(edgeVertex1);
		}
		c2 = (hashEdges.containsKey(edgeVertex2) && hashEdges.get(edgeVertex2) == edgeVertex1);
		System.out.println("c1: "+c1+" s11: "+s11 +" s12: "+s12+" c2: "+c2+"\n");
		System.out.println("a: "+a+" sb: "+b+"\n");
		if(c1 || c2){
			System.out.println("detecting duplicate edge\n");
			return computeEdges();
		}
		else {
			hashEdges.put(edgeVertex1,edgeVertex2);
			System.out.println("Insrted Key: "+ edgeVertex1+" Pair: "+hashEdges.get(edgeVertex1) +"\n");
			edgeVertex[0] = edgeVertex1;
			edgeVertex[1] = edgeVertex2;
			return edgeVertex;
		}

	}

	public static void main(String[] args){
		edgeVertex = new int[2];
		Vertices = Integer.parseInt(args[0]);
		EdgesCount = Integer.parseInt(args[1]);
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
			System.out.println("Some Exception detected: "+ e +"\n");
		}	
	}
}