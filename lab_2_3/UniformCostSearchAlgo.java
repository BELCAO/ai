package lab_2_3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier  = new  PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		
		while(!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if(currentNode.getLabel().equals(goal)) {
				return currentNode;
			}
			explored.add(currentNode);
			List<Edge> children = currentNode.getChildren();
			for(Edge child : children) {
				double newCost = currentNode.getPathCost() + child.getWeight();
				Node n = child.getEnd();
				if(!explored.contains(n) && !frontier.contains(n)) {
					frontier.add(n);
					n.setPathCost(newCost);
					n.setParent(currentNode);
			
				}
				else if(frontier.contains(n) && n.getPathCost() > newCost ) {
					n.setPathCost(newCost);
					n.setParent(currentNode);
				
				}
				}
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		 if (root == null) {
		        return null;
		    }

		    Node startNode = null;
		    PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		    List<Node> explored = new ArrayList<>();
		    frontier.add(root);

		    while (!frontier.isEmpty()) {
		        Node current = frontier.poll();

		        if (current.getLabel().equals(start)) {
		            startNode = current;
		        }

		        if (startNode != null && current.getLabel().equals(goal)) {
		            return current;
		        }

		        explored.add(current);

		        for (Edge edge : current.getChildren()) {
		            Node child = edge.getEnd();
		            double newCost = current.getPathCost() + edge.getWeight();

		            if (!frontier.contains(child) && !explored.contains(child)) {
		                child.setPathCost(newCost);
		                child.setParent(current);
		                frontier.add(child);
		            } else if (frontier.contains(child) && child.getPathCost() > newCost) {
		                frontier.remove(child);
		                child.setPathCost(newCost);
		                child.setParent(current);
		                frontier.add(child);
		            }
		        }
		    }

		    return null;
	}
	

    private class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
        	int re = Double.compare(node1.getPathCost(), node2.getPathCost());
        	if(re == 0) {
        		return node1.getLabel().compareTo(node2.getLabel());
        	}
        	else 
        		return re;
        	
        }
    }
}




	

