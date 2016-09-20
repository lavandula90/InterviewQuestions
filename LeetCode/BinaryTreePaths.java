package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(5);
		a1.left = a2;
		a1.right = a3;
		a2.right = a4;
		System.out.print(binaryTreePaths(a1));
	}
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if(root == null) return res;
		dfs(root, String.valueOf(root.val), res);
		return res;
		
	}
	public static void dfs(TreeNode root, String path, List<String> rst) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			rst.add(path);
			return;
		}
		if(root.left != null) dfs(root.left, path + "->" + String.valueOf(root.left.val), rst);
		if(root.right != null) dfs(root.right, path + "->" + String.valueOf(root.right.val), rst);
	}
}
