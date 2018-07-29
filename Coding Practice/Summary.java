/*
Given a list of ordered distinct integers from [0-99] 
summarize missing elements in string format.
Input: [0,1,2,50,52,75]
Output: "3-49,51,53-74,76-99"  
*/

public class Summary{

	public static String summarizeMiss(int[] nums){
		//Mainlogic 
		String res="";
		if(nums.length < 2)
			return res;
		for(int i=1;i<nums.length;i++){
			if(nums[i] != nums[i-1]+1){
				res = res + String.valueOf(nums[i-1]+1);
				if(nums[i-1]+1 != nums[i]-1){
					res = res + "-" + String.valueOf(nums[i]-1)+",";
				}
				else{
					if(i==nums.length-1)
					res = res + ",";
				}
			}			
		}
		return res;
	}

	public static void main(String[] args){

		int[] nums = {1, 2, 3, 5, 10, 12};
		System.out.println(summarizeMiss(nums));

	}
}