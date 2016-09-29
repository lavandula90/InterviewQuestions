package InterviewQuestions;

public class NthDigit {
	public static void main(String[] args) {
		System.out.println(findNthDigit(11));
	}
	
	public static int findNthDigit(int n) {
		int range = 9;    //number 1 - 9
        int numOfDigits = 1; 
        while((long)n > (long)numOfDigits * range) {
        	n -= numOfDigits * range;
        	range *= 10;
        	numOfDigits++;
        }
        int inTheNumber = (int) (Math.pow(10, numOfDigits - 1) + (n - 1) / numOfDigits);
        int position = (n - 1) % numOfDigits;
        return Character.getNumericValue(String.valueOf(inTheNumber).charAt(position));
    }
}
