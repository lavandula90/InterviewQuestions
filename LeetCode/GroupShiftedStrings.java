package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	public static void main(String[] args) {
		String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.print(groupStrings(strs));
	}
	public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> rst = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings) {
        	int offset = s.charAt(0) - 'a';
        	String shift = "";
        	for(int i = 1; i < s.length(); i++) {
        		shift += (s.charAt(i) - offset + 26) % 26;
        	}
        	if(!map.containsKey(shift)) {
        		List<String> set = new ArrayList<String>();
        		set.add(s);
        		map.put(shift, set);
        	}
        	else {
        		map.get(shift).add(s);
        	}
        }
        for(String key : map.keySet()) {
        	List<String> list = map.get(key);
        	Collections.sort(list);
        	rst.add(list);
        }
        return rst;
    }
}
