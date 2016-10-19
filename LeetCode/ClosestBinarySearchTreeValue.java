package InterviewQuestions;

public class ClosestBinarySearchTreeValue {
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(10);
		TreeNode a2 = new TreeNode(7);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(8);
		TreeNode a5 = new TreeNode(15);
		TreeNode a = new TreeNode(1500000000);
		TreeNode b = new TreeNode(1);
		a1.left = a2;
		a2.left = a3;
		a2.right = a4;
		a1.right = a5;
		a.left = b;
		System.out.println(closestValue(b, 4.428571));
	}
	public static int closestValue(TreeNode root, double target) {
        	TreeNode rst = root;
       		while(root != null) {
        		if(Math.abs(root.val - target) < Math.abs(rst.val - target)) {
                    		rst = root;
        	    	}
        	   	if(root.val > target) root = root.left;
        	    	else root = root.right;
            	}
            	return rst.val;
    	}
}
