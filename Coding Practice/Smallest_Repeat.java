public class Smallest_Repeat{
	
	public static int checkInBetw(String str, int diff, int ptr1, int ptr2){
		int range=0;
		System.out.println("ptr2: "+ptr2+" "+"diff: "+diff);
		if(ptr2+diff < str.length())
			range = diff;
		else
			return 0;

		for(int i=1;i<=range;i++){
			if(str.charAt(i) != str.charAt(ptr2+i))
				return 0;
		}
		System.out.println("In Betw Good ...");
		return 1;
	}

	public static String Solution(String str){
		String res = "None";
		char firstLetter = str.charAt(0);
		int ptr1=0, ptr2=1;
		int diff=0, flag1=0;	
		int i=1;int prevDiff=0;
		while(i<str.length()){
			if(str.charAt(i) == firstLetter){
				System.out.println("Match..Index: "+i);
				ptr2 = i;
				//find diff
				diff = ptr2-1-prevDiff;
				flag1 = checkInBetw(str,diff,ptr1, ptr2);	
				if(flag1 == 1 && i<str.length()-diff){

					res = str.substring(0,diff+1);
					System.out.println("Checking Rest..!");
					// ptr1 = i;
					i = i+diff;
					prevDiff = ptr2; 
					System.out.println("Restting i to: "+i);
					// System.out.println("Ptr1 to: "+ptr1);
				}
			}
			else if(i>str.length()/2){
				res = "None";
				return res;
			}
			else{
				prevDiff=0;
			}
			i+=1;
		}		
		return res;
	}

	public static void main(String[] args){
		String input = args[0];
		System.out.println(Solution(input));
	}
}