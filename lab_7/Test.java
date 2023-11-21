package lab_7;

public class Test {
    public static void main(String[] args) {
        // Test Genetic Algorithm
        GA_NQueenAlgo ga = new GA_NQueenAlgo();
        Node result = ga.execute();

        System.out.println("Genetic Algorithm Result:");
        System.out.println("Heuristic: " + result.getH());
        System.out.println("Solution:");
        result.displayBoard();

        // Test Mutate
        Node node = new Node();
        node.generateBoard();

        System.out.println("\nMutated Node:");
        ga.mutate(node);
        node.displayBoard();

        // Test Reproduce
        Node parent1 = new Node();
        Node parent2 = new Node();
        parent1.generateBoard();
        parent2.generateBoard();

        System.out.println("\nReproduced Child:");
        Node child = ga.reproduce(parent1, parent2);
        child.displayBoard();

        // Test Tournament Selection
        System.out.println("\nTournament Selection Winner:");
        Node tournamentWinner = ga.getParentByTournamentSelection();
        tournamentWinner.displayBoard();

        // Test Random Selection
        System.out.println("\nRandomly Selected Node:");
        Node randomNode = ga.getParentByRandomSelection();
        randomNode.displayBoard();
    }
}
