package InterviewQuestions;

import java.util.*;

public class PermutationSequence {
	public static void main(String[] args) {
		System.out.println(getPermutation(3,5));
	}
	public static String getPermutation(int n, int k) {
		if(n == 0) return "";
		StringBuilder res = new StringBuilder();
		List<Integer> num = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			num.add(i);
		}
		int factorial, index;
		for(int i = n; i > 0; i--) {
            factorial = nFactorial(i - 1);

            // calculate current number index
            index = k /factorial;

            res.append(num.get(index));

            // after adding, delete it from rest set
            num.remove(index);

            // update k for the next loop
            k = k % factorial;
            if(k == 0)
                k = factorial;
        }
        return res.toString();
	}
	public static int nFactorial(int n) {
		if(n == 0) return 1;
		return n * nFactorial(n-1);
	}
}
