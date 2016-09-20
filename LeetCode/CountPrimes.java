package InterviewQuestions;

public class CountPrimes {
	public static void main(String[] args) {
		System.out.println(countPrimes(100));
	}
	
	public static int countPrimes(int n) {
		if(n < 2) return 0;
		boolean[] notPrime = new boolean[n];
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2; i * i < n; i++) {
			if(!notPrime[i]) {
				int c = i * i;
				while(c < n) {
					notPrime[c] = true;
					c += i;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(!notPrime[i]) count++;
		}
		
		return count;
    }
}
