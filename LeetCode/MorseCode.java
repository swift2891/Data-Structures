import java.util.*;

public class MorseCode{
	static Hashtable<Character, String> defaultMorse = new Hashtable<Character,String>();	
	
	public static void defMorse(){
		List<String> morseList = Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");
		for(int i=0;i<26;i++){
			String s = morseList.get(i);
			s = s.replaceAll("^\"|\"$", "");
			morseList.set(i,s);
		}
		// System.out.println("g: "+morseList.get(6));
		defaultMorse.put('a',morseList.get(0));
		defaultMorse.put('b',morseList.get(1));
		defaultMorse.put('c',morseList.get(2));
		defaultMorse.put('d',morseList.get(3));
		defaultMorse.put('e',morseList.get(4));
		defaultMorse.put('f',morseList.get(5));
		defaultMorse.put('g',morseList.get(6));
		defaultMorse.put('h',morseList.get(7));
		defaultMorse.put('i',morseList.get(8));
		defaultMorse.put('j',morseList.get(9));
		defaultMorse.put('k',morseList.get(10));
		defaultMorse.put('l',morseList.get(11));
		defaultMorse.put('m',morseList.get(12));
		defaultMorse.put('n',morseList.get(13));
		defaultMorse.put('o',morseList.get(14));
		defaultMorse.put('p',morseList.get(15));
		defaultMorse.put('q',morseList.get(16));
		defaultMorse.put('r',morseList.get(17));
		defaultMorse.put('s',morseList.get(18));
		defaultMorse.put('t',morseList.get(19));
		defaultMorse.put('u',morseList.get(20));
		defaultMorse.put('v',morseList.get(21));
		defaultMorse.put('w',morseList.get(22));
		defaultMorse.put('x',morseList.get(23));
		defaultMorse.put('y',morseList.get(24));
		defaultMorse.put('z',morseList.get(25));
	}

	public int uniqueMorseRepresentations(String[] words) {
		defMorse();
    	int count=0;
    	Set<String> uniqueMorseCodes = new HashSet<String>();
    	// System.out.println(defaultMorse.get('a'));
    	for(int i=0;i<words.length;i++){
    		String curr = words[i];
    		String mcode="";
    		for(int j=0;j<curr.length();j++){
    			mcode = mcode.concat(defaultMorse.get(curr.charAt(j)));
    		}
    		// System.out.println("Adding: "+mcode);
    		uniqueMorseCodes.add(mcode);
    	}
    	count = uniqueMorseCodes.size();
    	return count;

    }

	public static void main(String[] args){
		MorseCode m = new MorseCode();
		String[] words = {"gin","zen","gig","msg"};

		System.out.println(m.uniqueMorseRepresentations(words));
	}
}