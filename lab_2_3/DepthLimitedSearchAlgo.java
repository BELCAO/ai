package lab_2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

    public Node execute(Node root, String goal, int limitedDepth) {
        if (root == null || limitedDepth < 0) {
            return null;
        }

        Stack<Node> frontier = new Stack<>();
        List<Node> explored = new ArrayList<>();
        frontier.push(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.pop();

            if (current.getDepth() > limitedDepth) {
                continue;  // Skip this node and its children because it's beyond the depth limit
            }

            if (current.getLabel().equals(goal)) {
                return current;  // Return the found node if it matches the goal
            }

            explored.add(current);

            List<Node> children = current.getChildrenNodes();
            for (Node child : children) {
                if (!frontier.contains(child) && !explored.contains(child)) {
                    child.setDepth(current.getDepth() + 1);  // Set the depth of the child node
                    child.setParent(current);  // Set the parent of the child node for path tracking
                    frontier.push(child);
                }
            }
        }

        return null;  

}
}
