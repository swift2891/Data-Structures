/*
Given a string A consisting of n characters and a string B consisting of m characters, write a function that will 
return the number of times A must be stated such that B is a substring of the repeated A. 
If B can never be a substring, return -1.

Example:
A = ‘abcd’
B = ‘cdabcdab’
The function should return 3 because after stating A 3 times, getting ‘abcdabcdabcd’, B is now a substring of A.

You can assume that n and m are integers in the range [1, 1000].
*/

public class MatchString{
	
	public static int Solution(String base, String target){
		int no_of_Times = 0;
		

		return no_of_Times;
	}

	public static void main(String[] args){
		String base = "abcd", target = "cdabcdab";
		System.out.println(Solution(base, target));
	}
}