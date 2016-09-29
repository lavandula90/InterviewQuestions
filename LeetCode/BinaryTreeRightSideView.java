package InterviewQuestions;

import java.util.*;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null ) return rst;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		if(i == size - 1) {
        			rst.add(cur.val);
        		}
        		if(cur.left != null) {
        			q.add(cur.left);
        		}
        		if(cur.right != null) {
        			q.add(cur.right);
        		}
        	}
        }
        return rst;
    }
}
