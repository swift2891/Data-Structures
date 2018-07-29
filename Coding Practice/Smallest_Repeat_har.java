public class Smallest_Repeat_har {
	public static void main(String[] args) {
		String str="abcabcdabcabcd";
		String str1="";
		int len=0;
		int i,j;
		boolean flag=false;
		for(i=0;i<str.length()/2;i++)
		{
		   str1=str.substring(0, i+1);
		   System.out.println(str1);
           flag=false;
           if((str.length())%(str1.length())==0)
           {
        	   for(j=i+1;j<str.length();j=j+str1.length())
		   {
			   System.out.println(j);
			   System.out.println(str.substring(j,j+str1.length()));
			   if(!str1.equals(str.substring(j,j+str1.length())))
				   flag=true;
		   }
		   if(flag==false)
		   {
			   len=i+1;
			   break;
		   }
           }
		}	
		System.out.println(len);
	}	
}