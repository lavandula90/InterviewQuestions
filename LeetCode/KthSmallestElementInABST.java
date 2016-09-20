package InterviewQuestions;

public class KthSmallestElementInABST {
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(5);
		TreeNode a2 = new TreeNode(3);
		TreeNode a3 = new TreeNode(1);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(9);
		TreeNode a6 = new TreeNode(7);
		TreeNode a7 = new TreeNode(10);
		a1.left = a2;
		a1.right = a5;
		a2.left = a3;
		a2.right = a4;
		a5.left = a6;
		a5.right = a7;
		System.out.println(kthSmallest(a1, 5));
	}
	public static int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if(k == count + 1) return root.val;
        if(k <= count) return kthSmallest(root.left, k);
        else if(k > count) return kthSmallest(root.right, k-1-count);
        return -1;
        
    }
	
	public static int count(TreeNode node) {
		if(node == null) return 0;
		return 1 + count(node.left) + count(node.right);
	}
}
