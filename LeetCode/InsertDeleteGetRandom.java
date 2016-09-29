package InterviewQuestions;

import java.util.*;

public class InsertDeleteGetRandom {
	public class RandomizedSet {
		ArrayList<Integer> nums;
		HashMap<Integer, Integer> numToPos;
		Random rand = new Random();

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        nums = new ArrayList<Integer>();
	        numToPos = new HashMap<Integer, Integer>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(numToPos.containsKey(val)) return false;
	        numToPos.put(val, nums.size());
	        nums.add(val);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!numToPos.containsKey(val)) return false;
	        int pos = numToPos.get(val);
	        if(pos < nums.size() - 1) {
	        	int lastNum = nums.get(nums.size() - 1);
	        	nums.set(pos, lastNum);
	        	numToPos.put(lastNum, pos);
	        }
	        numToPos.remove(val);
	        nums.remove(nums.size() - 1);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return nums.get(rand.nextInt(nums.size()));
	    }
	}
}
