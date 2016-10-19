package InterviewQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	public static void main(String[] args) {
		int[] a1 = {1, 2};
		int[] a2 = {1, 3};
		int[][] a = {a1, a2};
		System.out.println(kthSmallest(a, 2));
	}
	//Method 1
	public static int kthSmallestMid(int[][] matrix, int k) {
		int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left < right) {
        	int mid = left + (right - left) / 2;
        	int num = lowerThanMid(matrix, mid);
        	if(num < k) left = mid + 1;
        	else right = mid;
        }
        return right;
    }
	public static int lowerThanMid(int[][] matrix, int mid) {
		int i = matrix.length - 1, j = 0;
		int count = 0;
		while(i >= 0 && j < matrix.length) {
			if(mid > matrix[i][j]) {
				count += i + 1;
				j++;
			}
			else i--;
		}
		return count;
	}
	
	//Method 2
	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(pq.size() < k) {
					pq.offer(matrix[i][j]);
					continue;
				}
				else {
					int tmp = pq.peek();
					if(tmp > matrix[i][j]) {
						pq.poll();
						pq.offer(matrix[i][j]);
					}
				}
			}
		}
		return pq.poll();
	}
	
	//Method 3
	public int kthSmallest3(final int[][] matrix, int k) {
        int c = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            k, (o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        queue.offer(new int[] {0, 0});
        while (true) {
            int[] pair = queue.poll();
            if (++c == k) {
                return matrix[pair[0]][pair[1]];
            }
            if (pair[0] == 0 && pair[1] + 1 < matrix[0].length) {
                queue.offer(new int[] {0, pair[1] + 1});
            }
            if (pair[0] + 1 < matrix.length) {
                queue.offer(new int[] {pair[0] + 1, pair[1]});
            }
        }
    }
}
