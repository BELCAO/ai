package lab_9;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));

		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
		printNimGameTree(node, 0);
	}
	private static void printNimGameTree(Node node, int depth) {
        System.out.println("Current State (Depth " + depth + "): " + node.toString());
        if (!node.isTerminal()) {
            List<Node> successors = node.getSuccessors();
            for (Node successor : successors) {
                printNimGameTree(successor, depth + 1);
            }
        }
    }

}