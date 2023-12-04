package lab_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		List<Node> res = new ArrayList<>();
	    for (int i = 0; i < data.size(); i++) {
	    	int current = data.get(i);
	        for (int j = 1; j <= current/2; j++) {
	        	if(j != current/2) {
	            Node n = new Node();
	            n.add(j);
	            n.add(current -j);
	            res.add(n);
	      	}
	            
	        }
	    }

	    return res;

	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		data.sort(DESCOMPARATOR);
		 for (Integer pile : data) {
			 if(pile <=2 ) {
				 return true;
			 }	
		}
		return false;
e
		   
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
