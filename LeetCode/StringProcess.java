package InterviewQuestions;
import java.util.*;

public class StringProcess {
	public static void main(String[] argv) {
		String str = new String("amanaplanacanalpanama");
		System.out.println(partition(str));
	}
	public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<List<String>>();
        String tempString = null;
        //total number of substring bits. 
        int bits = s.length()-1;
        //total number of substring
        double count = Math.pow(2.0, bits);
        boolean valid;
//        System.out.println("count" + count);
        for(int i = 0; i < count; i++) {
        	valid = true;
            List<String> parts = new ArrayList<String>();
            //first index of substring
            int first = 0;
//            for(int j = 0; j < Math.ceil(log2(i)); j++) {
            //put the whole string into palindrome.
            if(i == 0) {
            	if(palindrome(s)) {
            		parts.add(s);
            		list.add(parts);
            	}
            	continue;
            } 
//            else if(i % 2 == 0 && i + 1 < s.length()) {
////            	System.out.println(first + " " + i + 1);
//            	String tempString1 = s.substring(first, i + 1);
//            	String tempString2 = s.substring(i + 1);
//            	if (palindrome(tempString1) && palindrome(tempString2)) {
////					System.out.println(tempString);
//
//					parts.add(tempString1);
//					parts.add(tempString2);
//				} else continue;
//            } 
            else {
//				for (int j = (int) Math.floor(log2(i)); j >= 0; j--) {
            	//
//            	System.out.println(Math.floor(log2(i)));
            	for (int j = 0; j <= (int) Math.floor(log2(i)); j++) {
					if (((i >> j) & 1) == 1) {
//						System.out.println(first + " " + j);
//						System.out.println(s.charAt(first) + " " + s.charAt(j));
						tempString = s.substring(first, j + 1);
						if (palindrome(tempString)) {
//							System.out.println(tempString);

							parts.add(tempString);
							first = j + 1;
						} else {
							valid = false;
							break;
						}
					} else continue;
				}
				if (valid && palindrome(s.substring(first))) {
//					System.out.println("true" + " " + tempString);
	            	parts.add(s.substring(first));
	            	list.add(parts);
	            }
	            else continue; 
            } 
        }
        return list;
    }
	private static double log2(int x){
        return Math.log10(x)/Math.log10(2);
    }
	public static boolean palindrome(String s) {
		for(int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i) == s.charAt(s.length()-1-i)) continue;
			else return false;
		}
		return true;
	}
}
