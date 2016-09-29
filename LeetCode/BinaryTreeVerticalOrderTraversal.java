package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null) return rst;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        int min = 0, max = 0;
        q.offer(root);
        cols.offer(0);
        while(!q.isEmpty()) {
        	TreeNode node = q.poll();
        	int col = cols.poll();
        	if(!map.containsKey(col)) {
        		map.put(col, new ArrayList<Integer>());
        	}
        	map.get(col).add(node.val);
        	
        	if(node.left != null) {
        		q.offer(node.left);
        		cols.offer(col - 1);
        		if(col <= min) min = col - 1;
        	}
        	
        	if(node.right != null) {
        		q.offer(node.right);
        		cols.offer(col + 1);
        		if(col >= max) max = col + 1;
        	}
        }
        for(int i = min; i <= max; i++) {
        	rst.add(map.get(i));
        }
        return rst;
    }
}
