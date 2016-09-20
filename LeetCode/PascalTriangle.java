package InterviewQuestions;

import java.util.*;

public class PascalTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(numRows == 0) return listOfList;
        list.add(1);
        listOfList.add(list);
        if(numRows == 1) return listOfList;
        
        for(int i = 1; i < numRows; i++) {
        	list = new ArrayList<Integer>();
        	if(i == 1) {
        		list.add(1);
            	list.add(1);
            	listOfList.add(list);
            	continue;
        	}
        	List<Integer> tempList = listOfList.get(i-1);
        	for(int j = 0; j < tempList.size(); j++) {
        		if(j == 0) {
        			list.add(tempList.get(j));
        			continue;
        		}
        		list.add(tempList.get(j-1) + tempList.get(j));
        	}
        	list.add(1);
        	listOfList.add(list);
        }
        
        return listOfList;
    }
}
