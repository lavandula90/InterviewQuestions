package InterviewQuestions;

public class LowestCommonAncestorOfABinaryTree {
	private static class TreeNode {
		int val;
        TreeNode left;
	    TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(5);
		TreeNode a3 = new TreeNode(1);
		TreeNode a4 = new TreeNode(6);
		TreeNode a5 = new TreeNode(2);
		TreeNode a6 = new TreeNode(0);
		TreeNode a7 = new TreeNode(8);
		
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a3.left = a6;
		a3.right = a7;
		
		System.out.println(lowestCommonAncestor(a1, a6, a7).val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        else return null;
    }
}
