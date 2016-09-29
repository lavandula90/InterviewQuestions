package InterviewQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlgorithmicCrush {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int size = scan.nextInt();
//		int numOfOp = scan.nextInt();
//		int[] numbers = new int[size];
//		for(int i = 0; i < numOfOp; i++) {
//			int start = scan.nextInt() - 1;
//			int end = scan.nextInt() - 1;
//			int addition = scan.nextInt();
//			for(int j = start; j <= end; j++) {
//				numbers[j] += addition;
//			}
//		}
//		int max = Integer.MIN_VALUE;
//		for(int i = 0; i < size; i++) {
//			if(numbers[i] > max) max = numbers[i];
//		}
//		System.out.println(max);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = bufferedReader.readLine().split("\\s");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            long[] start = new long[n + 1];
            long[] end = new long[n + 1];


            for (int i = 0; i < m; i++) {
                line = bufferedReader.readLine().split("\\s");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                long k = Long.parseLong(line[2]);

                start[a] += k;
                end[b] += k;
            }

            long sum = 0L;
            long max = -1L;

            for (int i = 1; i < n + 1; i++) {
                sum += start[i];

                if (sum > max) {
                    max = sum;
                }

                sum -= end[i];
            }

            System.out.println(max);
        } 
        catch (Exception e) {
            System.out.println(-1L);
        }
	}
}
