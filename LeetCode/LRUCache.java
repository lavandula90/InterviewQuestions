package InterviewQuestions;

import java.util.HashMap;

public class LRUCache {
	private class Node {
		int key;
		int value;
		Node prev;
		Node next;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
	
	private int capacity;
	private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(!hs.containsKey(key)) return -1;
        
        Node cur = hs.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        moveToTail(cur);
        
        return hs.get(key).value;
    }
    
    public void set(int key, int value) {
        if( get(key) != -1) {
        	hs.get(key).value = value;
        	return;
        }
        
        if(hs.size() == capacity) {
        	hs.remove(head.next.key);
        	head.next = head.next.next;
        	head.next.prev = head;
        }
        
        Node insert = new Node(key, value);
        hs.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node cur) {
    	cur.prev = tail.prev;
    	tail.prev = cur;
    	cur.prev.next = cur;
    	cur.next = tail;
    }
}
