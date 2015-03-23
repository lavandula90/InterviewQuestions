package InterviewQuestions;

import java.util.*;
public class Permutations {
	public static void main(String[] args) {
		int[] num = {1,2,3,4};
		System.out.println(permute(num));
	}
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
	    List<Integer> list = new ArrayList<Integer>();
	    backtrack(lists, list, num);
	    return lists;
        
    }
	public static void backtrack(List<List<Integer>> lists, List<Integer> list, int[] num){
	    if(list.size() == num.length) {
	        lists.add(new ArrayList<Integer>(list));
	        return;
	    }
	    for(int i:num){
	        if(!list.contains(i)){
	            list.add(i);
	            backtrack(lists, list, num);
	            list.remove(Integer.valueOf(i));
	        }
	    }
	}
}
