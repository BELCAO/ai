package lab6;

public class HillClimbingSearchNQueenAlgo implements ILocalSearchAlgo {
    int stepclimbed = 0;
    int stepClimbedAfterRandomRestart = 0;

    @Override
    public Node execute(Node initialState) {
        Node current = new Node(initialState);
        while (true) {
            Node neighbor = current.getBestCandidate();
            if (neighbor.getH() < current.getH()) {
                current = neighbor;
                stepclimbed++;
                stepClimbedAfterRandomRestart++;
            } else {
                return current;
            }
        }
    }
}
