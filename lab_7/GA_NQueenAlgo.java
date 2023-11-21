package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		initPopulation();

		for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
			Collections.sort(population);

			if (population.get(0).getH() == 0) {
				return population.get(0);
			}
			List<Node> newPopulation = new ArrayList<>();
			newPopulation.add(population.get(0));
			for (int i = 1; i < POP_SIZE; i++) {
				Node parent1 = getParentByTournamentSelection();
				Node parent2 = getParentByTournamentSelection();

				Node child = reproduce(parent1, parent2);

				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}

				newPopulation.add(child);
			}
			population = newPopulation;
		}
		Collections.sort(population);
		return population.get(0);

	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		int queenIndex = rd.nextInt(Node.N);
		int newRow = rd.nextInt(Node.N);
		node.setRow(queenIndex, newRow);
	}
	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node child = new Node(); 
		child.generateBoard();
		int c = rd.nextInt(Node.N);

		for (int i = 0; i <= c; i++) {
			child.setRow(i, x.getRow(i));
			 
		}
		for(int i =c+1; i<Node.N; i ++) {
			child.setRow(i, y.getRow(i));
		}
		return child;

	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here
		List<Node> tournamentParticipants = new ArrayList<>();

        // Select K random individuals for the tournament
        for (int i = 0; i < 5; i++) {
            int randomIndex = rd.nextInt(POP_SIZE);
            tournamentParticipants.add(population.get(randomIndex));
        }

        // Sort the participants and return the best one
        Collections.sort(tournamentParticipants);
        return tournamentParticipants.get(0);
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		 int randomIndex = rd.nextInt(POP_SIZE);
	        return population.get(randomIndex);
	}
}
