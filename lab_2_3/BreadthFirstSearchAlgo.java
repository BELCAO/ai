package lab_2_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new ArrayList<>();
	
		
		frontier.add(root);

		while(!frontier.isEmpty()) {
			Node nodeCurrent = frontier.poll();
			if(nodeCurrent.getLabel().equals(goal)) {
				return nodeCurrent;
			}
			explored.add(nodeCurrent);
			List<Node> children = nodeCurrent.getChildrenNodes();
			for(Node child : children) {
				if(!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					child.setParent(nodeCurrent);
				}
				
			}
		
		}
		return null;
		
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
