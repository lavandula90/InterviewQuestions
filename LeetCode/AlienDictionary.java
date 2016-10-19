package InterviewQuestions;

import java.util.*;

public class AlienDictionary {
	public static void main(String[] args) {
		String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
		System.out.println(alienOrder(words));
	}
	public static class Node {
		public int degree;
		public ArrayList<Integer> neighbor = new ArrayList<Integer>();
		Node() {
			degree = 0;
		}
	}
	public static String alienOrder(String[] words) {
		Node[] node = new Node[26];
		boolean[] happen = new boolean[26];
		for(int i = 0; i < 26; i++) {
			node[i] = new Node();
		}
		
		//Build the graph
		for(int i = 0; i < words.length; i++) {
			int startPoint = 0, endPoint = 0;
			for(int j = 0; j < words[i].length(); j++) {
				happen[words[i].charAt(j) - 'a'] = true;
			}
			if(i != words.length - 1) {
				for(int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
					if(words[i].charAt(j) != words[i + 1].charAt(j)) {
						startPoint = words[i].charAt(j) - 'a';
						endPoint = words[i + 1].charAt(j) - 'a';
						break;
					}
				}
			}
				   
			if(startPoint != endPoint) {
				node[startPoint].neighbor.add(endPoint);
				node[endPoint].degree++;
			}
		}
		
		//Topological Sort
		Queue<Integer> q = new LinkedList<Integer>();
		String rst = "";
		for(int i = 0; i < 26; i++) {
			if(node[i].degree == 0 && happen[i]) {
				q.offer(i);
				rst = rst + (char)(i +'a');
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i : node[cur].neighbor) {
				node[i].degree--;
				if(node[i].degree == 0) {
					q.offer(i);
					rst = rst + (char)(i +'a');
				}
			}
		}
		for(int i = 0; i < 26; i++) {
			if(node[i].degree != 0) return "";
		}
		return rst;
    }
}
