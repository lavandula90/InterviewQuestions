package InterviewQuestions;

public class BinaryTreeLongestConsecutiveSequence {
	
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(3);
		TreeNode a3 = new TreeNode(2);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		a1.right = a3;
		a3.left = a2;
		a3.right = a4;
		a4.right = a5;
		System.out.println(longestConsecutive(a1));
	}
	
	public static int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }
	
	public static int dfs(TreeNode root, int count, int val) {
		if(root == null) return count;
		count = (root.val - val == 1)? count + 1 : 0;
		int left = dfs(root.left, count, root.val);
		int right = dfs(root.right, count, root.val);
		return Math.max(count, Math.max(left, right));
	}
}
