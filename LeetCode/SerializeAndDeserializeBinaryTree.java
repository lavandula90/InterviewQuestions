package InterviewQuestions;

public class SerializeAndDeserializeBinaryTree {
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		a1.left = a2;
		a1.right = a3;
		a3.left = a4;
		a3.right = a5;
		System.out.println(serialize(a1));
		System.out.println(deserialize("1,2,null,null,3,4,null,null,5,null,null,"));
	}
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    public static void serializeHelper(TreeNode root, StringBuilder res) {
    	if(root == null) {
    		res.append("null,");
    		return;
    	}
    	res.append(root.val+",");
    	serializeHelper(root.left, res);
    	serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	TreeNode root = null;
    	StringBuilder sb = new StringBuilder(data);
		return deserializeHelper(root, sb);
        
    }
    
    public static TreeNode deserializeHelper(TreeNode root, StringBuilder str) {
    	if(str.length() == 0) return null;
    	
    	String temp = str.substring(0, str.indexOf(","));
    	str.delete(0, str.indexOf(",") + 1);
    	if(temp.equals("null")) {
    		return null;
    	}
    	else {
    		root = new TreeNode(Integer.parseInt(temp));
    		root.left = deserializeHelper(root.left, str);
    		root.right = deserializeHelper(root.right, str);
    	}
    	
    	return root;
    }
}
