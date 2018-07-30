import java.util.*;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        
    	List<List<Integer>> output = null;
        List<Integer> tempOut = null;

        if(S == null)
        	return output;
        
        tempOut = new ArrayList<Integer>();
        output = new ArrayList<List<Integer>>();

        String[] splitted = S.split("");
        String prevLetter = splitted[0];
        // System.out.println("prev letter  "+prevLetter);
        int cntr=1, startPos = 0, endPos = 0;
        for(int i=1;i<splitted.length;i++){
        	System.out.println(splitted[i]+" == ? "+prevLetter);
        	if(prevLetter.equals(splitted[i])){
        		cntr+=1;
        		System.out.println("cntr = "+cntr);
        	}else{
        		if(cntr>2){
        			tempOut = new ArrayList<Integer>();
        			tempOut.add(startPos);
        			tempOut.add(endPos);
        			output.add(tempOut);
        		}

        		cntr = 1;
        		prevLetter = splitted[i];
        	}
        	if(cntr > 2){
        		//gather starting and ending positions
        		if(cntr==3)
        			startPos = i - 2;
        		endPos = i;
        		// System.out.println("Eureka  "+splitted[i]+" "+startPos+" "+endPos);
        	}
        }
        if(cntr>2){
        			tempOut = new ArrayList<Integer>();
        			tempOut.add(startPos);
        			tempOut.add(endPos);
        			output.add(tempOut);
        }

        return output;
    }

    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.largeGroupPositions("aaa"));

    }
}