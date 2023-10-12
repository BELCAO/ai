package lab_2_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
	
	
		
		while(!frontier.isEmpty()) {
			Node nodeCurrent = frontier.pop();
			if(nodeCurrent.getLabel().equals(goal)) {
				return nodeCurrent;
			}
			explored.add(nodeCurrent);
			List<Node> childrent = nodeCurrent.getChildrenNodes();
			for(Node child : childrent) {
				if(!frontier.contains(child) && !explored.contains(child)) {
					frontier.push(child);
					child.setParent(nodeCurrent);
				}
			}
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
