package InterviewQuestions;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class SameTree {
	public static void main(String[] argv) {
		TreeNode a1 = new TreeNode(1);
		TreeNode b1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode b2 = new TreeNode(3);
		a1.left = a2;
		b1.left = b2;
		System.out.println(isSameTree(a1, b1));
	}
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		else if(p != null && q != null) {
			if(p.val != q.val) return false;
			else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		else return false;
    }
}
