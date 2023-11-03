package lab_5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch implements IPuzzleAlgo {

    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
        List<Node> explored = new ArrayList<>();
        Node initialNode = model.getInitialState();
        initialNode.setH(model.computeH1(initialNode)); // Change to computeH2 if using h2
        initialNode.setG(0);
        frontier.add(initialNode);
        
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (currentNode.equals(model.getGoalState())) {
                return currentNode; // Return the goal node
            }
            explored.add(currentNode);
            List<Node> successors = model.getSuccessors(currentNode);

            for (Node successor : successors) {
                int tentativeG = currentNode.getG() + 1; // Assuming the cost of each step is 1

                if (!explored.contains(successor) && !frontier.contains(successor)) {
                    successor.setG(tentativeG);
                    successor.setH(model.computeH1(successor)); // Change to computeH2 if using h2

                    frontier.add(successor);
                } else if (tentativeG < successor.getG()) {
                    successor.setG(tentativeG);

                    successor.setH(model.computeH1(successor)); // Change to computeH2 if using h2

                    if (frontier.contains(successor)) {
                        frontier.remove(successor);
                    }
                    frontier.add(successor);
                }
            }
        }

        return null; 
    }
}
