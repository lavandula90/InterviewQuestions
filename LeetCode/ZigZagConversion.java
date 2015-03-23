package InterviewQuestions;

public class ZigZagConversion {
	public static void main(String[] args) {
		String s = new String("abcdefghijklmn");
		System.out.println(convert(s,5));
	}
	public static String convert(String s, int nRows) {
		StringBuilder result=new StringBuilder();
	    if(s.length() <= nRows || nRows == 1) return s;
	    for(int i=0;i<nRows;i++)
	    {
	        int gap = 2*nRows-2*i-2;
	        int j=i;
	        while(j<s.length())
	        {
	            result.append(s.substring(j,j+1));
	            j=j+gap;
	            if(j<s.length() && i!=nRows-1) result.append(s.substring(j,j+1));
	            if(i!=0) j=j+2*i;
	            else j=j+gap;
	        }

	    }
	    return result.toString();
	}
}
