package InterviewQuestions;

class myNode {
	int val;
	myNode left;
	myNode right;
	myNode(int x) { val = x; }
}

public class PathSum {
	public static void main(String[] args) {
		myNode a = new myNode(5);
		myNode b = new myNode(4);
		myNode c = new myNode(11);
		myNode d = new myNode(7);
		myNode e = new myNode(2);
		a.left = b;
		b.left = c;
		c.left = d;
		c.right = e;
		System.out.println(hasPathSum(a, 22));
	}
	
	public static boolean hasPathSum(myNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null && root.val == sum) return true;
		return (hasPathSum(root.left, (sum-root.val)) || hasPathSum(root.right, (sum-root.val)));
		
//        Stack<TreeNode> s = new Stack<TreeNode>();
//        TreeNode n = root;
//        int tempSum = 0;
//        while(n != null) {
//        	
//        	s.push(n);
//        	tempSum += n.val;
//        	
//        	if(tempSum == sum) return true;
//        	
//        	else if(tempSum > sum) {
//        		do {
//        			n = s.pop();
//        			tempSum -= n.val;
//        			n = s.peek();
//        			n = n.right;
//        		}
//        		while(n == null);
//        		continue;
//        	}
//        	
//        	else if(tempSum < sum) {
//        		if(n.left != null) n = n.left;
//        		else if(n.right != null) n = n.right;
//        		
//        	}
//        	
//        }
//        return false;
    }
	
}
