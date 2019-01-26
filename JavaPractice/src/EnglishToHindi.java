
public class EnglishToHindi {
	public static void main(String args[]) {
		
		String englishAlphabet=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//char [] englishAlphabetArray= englishAlphabet.toCharArray();
		String hindiLetters=" \u0904\u097f\u0915\u0921\u090f\u092b\u0917\u0939\u0908\u091c\u0915\u0932\u092e\u0928\u0913\u092a\u0915\u0930\u0938\u091f\u092f\u0935\u0935\u0937\u092f\u095b";
		//char [] hindiLetterArray=str.toCharArray();
		String s1="Happy Republic Day";
		String input=s1.toUpperCase();
		String result="";
		for(int i=0;i<input.length();i++)
		{	
			int index=englishAlphabet.indexOf(input.charAt(i));
			result+=Character.toString(hindiLetters.charAt(index));
		}
		

			System.out.println(result);
		
	}

}
