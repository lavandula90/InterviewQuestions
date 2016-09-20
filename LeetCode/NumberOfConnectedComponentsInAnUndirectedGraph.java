package InterviewQuestions;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
	public static void main(String[] args) {
		int[] a1 = {0, 1};
		int[] a2 = {1, 2};
		int[] a3 = {3, 4};
		int[] a4 = {2, 3};
		int[][] a = {a1, a2, a3, a4};
		System.out.println(countComponents(5, a));
	}
	public static int countComponents(int n, int[][] edges) {
		int[] roots = new int[n];
        for(int i = 0; i < n; i++) {
        	roots[i] = i;
        }
        for(int i = 0; i < edges.length; i++) {
        	int root1 = getRoot(roots, edges[i][0]);
        	int root2 = getRoot(roots, edges[i][1]);
        	if(root1 != root2) {
        		n--;
        		roots[root1] = root2;
        	}
        }
        return n;
    }
	public static int getRoot(int roots[], int e) {
		while(roots[e] != e) {
			roots[e] = roots[roots[e]];
			e = roots[e];
		}
		return e;
	}
}
