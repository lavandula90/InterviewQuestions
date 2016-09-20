package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public static List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        String cur = "JFK";
        for(int i = 0; i < tickets.length; i++) {
        	if(!map.containsKey(tickets[i][0])) {
        		map.put(tickets[i][0], new PriorityQueue<String>());
        	}
        	map.get(tickets[i][0]).add(tickets[i][1]);
        }
        List<String> list = new ArrayList<String>();
        dfs(cur, map, list);
        Collections.reverse(list);
        return list;
    }
	
	public static void dfs(String cur, Map<String, PriorityQueue<String>> map, List<String> rst) {
		while(map.containsKey(cur) && !map.get(cur).isEmpty()) {
			dfs(map.get(cur).poll(), map, rst);
		}
		rst.add(cur);
	}
}
