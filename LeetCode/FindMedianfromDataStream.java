package InterviewQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(-1);
		System.out.println(mf.findMedian());
		mf.addNum(-2);
		System.out.println(mf.findMedian());
		mf.addNum(-3);
		System.out.println(mf.findMedian());
		mf.addNum(-4);
		System.out.println(mf.findMedian());
		mf.addNum(-5);
		System.out.println(mf.findMedian());
	}
	private static class MedianFinder {
		public PriorityQueue<Integer> minHeap, maxHeap;
		public MedianFinder() {
			minHeap = new PriorityQueue<Integer>();
			maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		}

	    // Adds a number into the data structure.
	    public void addNum(int num) {
	        maxHeap.add(num);
	        minHeap.add(maxHeap.poll());
	        if(minHeap.size() > maxHeap.size()) {
	        	maxHeap.add(minHeap.poll());
	        }
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        if(minHeap.size() == maxHeap.size()) {
	        	return (minHeap.peek() + maxHeap.peek()) * 0.5;
	        }
	        else return maxHeap.peek();
	    }
	};
}
