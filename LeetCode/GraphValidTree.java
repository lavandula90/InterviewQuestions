package InterviewQuestions;

public class GraphValidTree {
	public static void main(String[] args) {
		int[] a1 = {0, 1};
		int[] a2 = {1, 2};
		int[] a3 = {2, 3};
		int[] a4 = {1, 3};
		int[] a5 = {1, 4};
		int[][] a = {a1, a2, a3, a4, a5};
		System.out.println(validTree(5, a));
	}
	public static boolean validTree(int n, int[][] edges) {
        int[] root = new int[n+1];
        for(int i = 0; i < n; i++) {
        	root[i] = i;
        }
        for(int i = 0; i < edges.length; i++) {
        	int root1 = find(root, edges[i][0]);
        	int root2 = find(root, edges[i][1]);
        	if(root1 == root2) return false;
        	root[root2] = root1;
        }
        return n - 1 == edges.length;
    }
	
	public static int find(int[] root, int e) {
		if(root[e] == e) return e;
		else return find(root, root[e]);
	}
}
