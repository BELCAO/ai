package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
    public static final int N = 8;
    private Queen[] state;

    public Node() {
        state = new Queen[N];
    }

    public Node(Queen[] state) {
        this.state = new Queen[N];
        for (int i = 0; i < state.length; i++) {
            this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
        }
    }

    public Node(Node n) {
        this.state = new Queen[N];
        for (int i = 0; i < N; i++) {
            Queen qi = n.state[i];
            this.state[i] = new Queen(qi.getRow(), qi.getColumn());
        }
    }

    public void generateBoard() {
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            state[i] = new Queen(random.nextInt(N), i);
        }
    }

    public int getH() {
        int heuristic = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (state[i].isConflict(state[j])) {
                    heuristic++;
                }
            }
        }
        return heuristic;
    }

    public List<Node> generateAllCandidates() {
        List<Node> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Node tmp = new Node(this.state);
            tmp.state[i].move();
            result.add(tmp);
        }
        return result;
    }

    public Node selectNextRandomCandidate() {
        Node re = new Node(this.state);
        Random r = new Random();
        int i = r.nextInt(N);
        int row = r.nextInt(N);
        re.state[i].setRow(row);
        return re;
    }

    public void displayBoard() {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            board[state[i].getRow()][state[i].getColumn()] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }

    public Node getBestCandidate() {
        List<Node> candidates = generateAllCandidates();
        Node bestCandidate = candidates.get(0);
        int minHeuristic = bestCandidate.getH();

        for (Node candidate : candidates) {
            int currentHeuristic = candidate.getH();
            if (currentHeuristic < minHeuristic) {
                minHeuristic = currentHeuristic;
                bestCandidate = candidate;
            }
        }

        return bestCandidate;
    }
}
