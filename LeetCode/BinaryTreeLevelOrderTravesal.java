package InterviewQuestions;

import java.util.*;

public class BinaryTreeLevelOrderTravesal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null) return rst;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
        	List<Integer> level = new ArrayList<Integer>();
        	int size = q.size();
        	for(int i = 0; i < size; i++) {
        		TreeNode head = q.poll();
        		level.add(head.val);
        		if(head.left != null) {
        			q.offer(head.left);
        		}
        		if(head.right != null) {
        			q.offer(head.right);
        		}
        	}
        	rst.add(level);
        }
        return rst;
    }
}
