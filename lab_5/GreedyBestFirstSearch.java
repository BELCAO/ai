package lab_5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
	    PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        List<Node> explored = new ArrayList<>();
        Node initialNode = model.getInitialState();
        initialNode.setH(model.computeH1(initialNode)); // Change to computeH2 if using h2
        frontier.add(initialNode);
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (currentNode.equals(model.getGoalState())) {
                return currentNode;
            }
            explored.add(currentNode);
            List<Node> successors = model.getSuccessors(currentNode);

            for (Node successor : successors) {
                if (!explored.contains(successor) && !frontier.contains(successor)) {
                    successor.setH(model.computeH1(successor)); // 

                    frontier.add(successor);
                }
            }
        }

        return null; 
    }
	}


