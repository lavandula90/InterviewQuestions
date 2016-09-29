package InterviewQuestions;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] s = {"ate","tea"};
		System.out.print(groupAnagrams(s));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null || strs.length == 0) return null;
		List<List<String>> rst = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
        	char[] ch = s.toCharArray();
        	Arrays.sort(ch);
        	String key = String.valueOf(ch);
        	if(map.containsKey(key)) {
        		map.get(key).add(s);
        	}
        	else {
        		List<String> list= new ArrayList<String>();
        		list.add(s);
        		map.put(key, list);
        	}
        }
        for(List<String> item : map.values()) {
        	rst.add(item);
        }
        return rst;
    }
}
