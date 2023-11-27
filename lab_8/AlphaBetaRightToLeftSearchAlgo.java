package lab_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

    @Override
    public void execute(Node node) {
        int maxValue = maxValueRightToLeft(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (Node child : node.getChildren()) {
            if (child.getValue() == maxValue) {
                System.out.println("Alpha-Beta Right-to-Left Pruning Action: " + child.getLabel() + ", Value: " + child.getValue());
                return;
            }
        }
    }

    public int maxValueRightToLeft(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }
        int v = Integer.MIN_VALUE;
        List<Node> reversedChildren = new ArrayList<>(node.getChildren());
        Collections.reverse(reversedChildren); // Reverse the order
        for (Node child : reversedChildren) {
            v = Math.max(v, minValueRightToLeft(child, alpha, beta));
            if (v >= beta) {
                return v;
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    public int minValueRightToLeft(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }
        int v = Integer.MAX_VALUE;
        List<Node> reversedChildren = new ArrayList<>(node.getChildren());
        Collections.reverse(reversedChildren); // Reverse the order
        for (Node child : reversedChildren) {
            v = Math.min(v, maxValueRightToLeft(child, alpha, beta));
            if (v <= alpha) {
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }
}
