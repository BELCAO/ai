package lab_4;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class AStarSearchAlgo implements IInformedSearchAlgo {
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
	                else if (frontier.contains(child)&& child.getG() > current.getG() + edge.getWeight()) {
	                	frontier.remove(child);
	                	child.setG(current.getG() + edge.getWeight());
	                	child.setParent(current);
	                	frontier.add(child);
	                }
	            }
	        }
		return null;
	}
	@Override
	public Node execute(Node root, String start, String goal) {
	    PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByGn());
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

	            double newG = current.getG() + edge.getWeight();

	            if (!explored.contains(child) && !frontier.contains(child)) {
	                child.setParent(current);
	                child.setG(newG);
	                double f = newG + child.getH();
	                child.setH(f);
	                frontier.add(child);
	            } else if (frontier.contains(child) && newG < child.getG()) {
	                child.setParent(current);
	                child.setG(newG);
	                double f = newG + child.getH();
	                child.setH(f);
	                frontier.remove(child);
	                frontier.add(child);
	            }
	        }
	    }

	    return null;
	}

	
}
