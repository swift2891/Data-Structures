public class TwoSum{

	public int[] twoSum(int[] nums, int target) {
        //Brute Force
        int currentIndex = 0;
        int[] res = {0,0};
        int i=0, j =0;
        int len = nums.length;
        
        outerloop:
        for(i=0;i<len-1;i++){
            currentIndex = nums[i];
            res[0] = i;
            for(j=i+1;j<len;j++){
                if(nums[j] == target - nums[i]){
                    res[1] = j;
                    break outerloop;
                }
            }                    
        }
        return res;
    }

	public static void main(String[] args){
		TwoSum ts = new TwoSum();
		System.out.println("Hello");
		int[] nums = {0, 1, 2, 3};
		ts.twoSum(nums, 5);
	}
}