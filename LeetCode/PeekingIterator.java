package InterviewQuestions;

import java.util.Iterator;

public class PeekingIterator {
	private Integer next;
	private Iterator<Integer> iter;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    if(iterator.hasNext()) next = iterator.next();
	    else next = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
	    Integer res = next;
	    next = iter.hasNext() ? iter.next() : null;
	    return res;
	}

	public boolean hasNext() {
	    return next != null;
	}
}
