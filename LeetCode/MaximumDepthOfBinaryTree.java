package InterviewQuestions;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode b1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode b2 = new TreeNode(3);
		a1.left = a2;
		b1.left = b2;
		System.out.println(maxDepth(a1));
	}
	
	public static int maxDepth(TreeNode root) {
        if(root != null) return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        
        return 0;
    }
}
