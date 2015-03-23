package InterviewQuestions;

import java.util.HashMap;
import java.util.Iterator;

public class MajorityElement {
	public static void main(String[] args) {
		int[] n = {10,9,9,9,10,11,11,11,11,11,11};
		System.out.println(majorityElement(n));
	}
	public static int majorityElement(int[] num) {
        int majorTimes = (int) Math.floor(num.length/2.0);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
        	if(map.containsKey(num[i])) {
        		map.put(num[i], map.get(num[i])+1);
        	}
        	else {
        		map.put(num[i], 1);
        	}
        }
        int major = 0;
        Iterator<Integer> keySetIterator = map.keySet().iterator();
        while(keySetIterator.hasNext()) {
        	Integer key = keySetIterator.next();
        	if(map.get(key) > majorTimes) {
        		major = key;
        		return major;
        	}
        }
		return major;
    }
}
