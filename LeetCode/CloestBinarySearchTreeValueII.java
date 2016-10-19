package InterviewQuestions;

import java.util.*;

public class CloestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> rst = new ArrayList<Integer>();
        
        Stack<Integer> s1 = new Stack<>();    //predecessors
        Stack<Integer> s2 = new Stack<>();    //sccessors
        
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        
        while(k-- > 0) {
        	if(s1.isEmpty()) rst.add(s2.pop());
        	else if(s2.isEmpty()) rst.add(s1.pop());
        	else if(Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) rst.add(s1.pop());
        	else rst.add(s2.pop());
        }
        return rst;
    }
	
	public void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> s) {
		if(root == null) return;
		inorder(reverse? root.right : root.left, target, reverse, s);
		if((reverse && root.val <= target) || (!reverse && root.val > target)) return;
		s.push(root.val);
		inorder(reverse? root.left : root.right, target, reverse, s);
	}
}
