package InterviewQuestions;

import java.util.*;

public class DesignPhoneDirectory {
	private class PhoneDirectory {
		private Set<Integer> set;;

	    public PhoneDirectory(int maxNumbers) {
		    set = new LinkedHashSet<>();
		        
		    for(int i=0; i<maxNumbers; i++){
		        set.add(i);
		    }
		}
		    
		/** Provide a number which is not assigned to anyone.
		   @return - Return an available number. Return -1 if none is available. */
		public int get() {
	        Iterator iter = set.iterator();
		    	
	        if(!set.isEmpty()){
		        int val = (int) iter.next();
		        set.remove(val);
		        return val;
		    }
		    return -1;
	    }
		    
	    /** Check if a number is available or not. */
	    public boolean check(int number) {
		    return set.contains(number);
	    }
		    
	    /** Recycle or release a number. */
	    public void release(int number) {
		    set.add(number);
	    }
	}
}
