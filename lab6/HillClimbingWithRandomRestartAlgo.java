package lab6;

public class HillClimbingWithRandomRestartAlgo implements ILocalSearchAlgo {
	int randomRestarts = 0;

	@Override
	public Node execute(Node initialState) {
		// TODO Auto-generated method stub
		HillClimbingSearchNQueenAlgo algo = new HillClimbingSearchNQueenAlgo();
		Node state = algo.execute(initialState);
		while(state.getH() != 0) {
			state = new Node();
			state.generateBoard();
			randomRestarts ++;
			algo.stepClimbedAfterRandomRestart = 0;
			state = algo.execute(state);
		}
		System.out.println("Step climbed: " + algo.stepclimbed);
		System.out.println("Number restart: " + randomRestarts);
		System.out.println("Step climed after random restart: " + algo.stepClimbedAfterRandomRestart);
		return state;
		
	}

}
