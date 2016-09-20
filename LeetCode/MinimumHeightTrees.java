package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {
	public static void main(String[] args) {
		int[] a1 = {0, 3};
		int[] a2 = {1, 3};
		int[] a3 = {2, 3};
		int[] a4 = {4, 3};
		int[] a5 = {5, 4};
		int[][] a = {a1, a2, a3, a4, a5};
		System.out.print(findMinHeightTrees(6, a));
	}
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        List<Integer> leaves = new ArrayList<Integer>();
        if(n == 0) return leaves;
		if(n == 1) {
			leaves.add(0);
			return leaves;
		}
        for(int i = 0; i < n; i++) {
        	graph.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++) {
        	graph.get(edges[i][0]).add(edges[i][1]);
        	graph.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < graph.size(); i++) {
        	if(graph.get(i).size() == 1) {
        		leaves.add(i);
        	}
        }
        while(n > 2) {
        	n -= leaves.size();
        	List<Integer> newLeaves = new ArrayList<Integer>();
        	for(int i = 0; i < leaves.size(); i++) {
        		for(int j = 0; j < graph.size(); j++) {
        			if(graph.get(j).contains(leaves.get(i))) {
        				graph.get(j).remove(leaves.get(i));
        				if(graph.get(j).size() == 1) {
        					newLeaves.add(j);
        				}
        			}
        		}
        	}
        	leaves = newLeaves;
        }
        return leaves;
    }
	
	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (n == 0) return new ArrayList<>();
        else if (n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            lists[v1].add(v2);
            lists[v2].add(v1);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (lists[i].size() == 1) {
                leaves.add(i);
            }
        }
        int count = n;
        while (count > 2) {
            int size = leaves.size();
            count -= size;
            List<Integer> newLeaves = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int leaf = leaves.get(i);
                for (int j = 0; j < lists[leaf].size(); j++) {
                    int toRemove = lists[leaf].get(j);
                    lists[toRemove].remove(Integer.valueOf(leaf));
                    if (lists[toRemove].size() == 1)
                        newLeaves.add(toRemove);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
