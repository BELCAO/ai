package lab_4;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		List<Node> explored = new ArrayList<>();
		 frontier.add(root);
	        while (!frontier.isEmpty()) {
	            Node current = frontier.poll();
	            if (current.getLabel().equals(goal)) {
	                return current; 
	            }
	            explored.add(current);
	            List<Edge> children = current.getChildren();
	            for (Edge edge : children) {
	                Node child = edge.getEnd();
	                if (!explored.contains(child) && !frontier.contains(child)) {
	                	child.setParent(current);
	                	child.setG(current.getG() + edge.getWeight());
	                    frontier.add(child);
	                }
	                
	            }
	        }
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
	    Node startNode = new Node(start);
	    Node goalNode = new Node(goal);
	    
	    PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByGn());
	    List<Node> explored = new ArrayList<>();
	    
	    frontier.add(startNode);

	    while (!frontier.isEmpty()) {
	        Node current = frontier.poll();

	        if (current.getLabel().equals(goal)) {
	            return current; // Goal node found
	        }

	        explored.add(current);
	        List<Edge> children = current.getChildren();

	        for (Edge edge : children) {
	            Node child = edge.getEnd();
	            if (!explored.contains(child) && !frontier.contains(child)) {
	                child.setParent(current);
	                child.setG(current.getG() + edge.getWeight());
	                frontier.add(child);
	            }
	        }
	    }

	    return null;
	}

	
}
