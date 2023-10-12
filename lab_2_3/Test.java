package lab_2_3;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		    Node nodeS = new Node("S");
		    Node nodeA = new Node("A");
		    Node nodeB = new Node("B");
		    Node nodeC = new Node("C");
		    Node nodeD = new Node("D");
		    Node nodeE = new Node("E");
		    Node nodeF = new Node("F");
		    Node nodeG = new Node("G");
		    Node nodeH = new Node("H");

		    nodeS.addEdge(nodeA, 5);
		    nodeS.addEdge(nodeB, 2);
		    nodeS.addEdge(nodeC, 4);
		    nodeA.addEdge(nodeD, 9);
		    nodeA.addEdge(nodeE, 4);
		    nodeB.addEdge(nodeG, 6);
		    nodeC.addEdge(nodeF, 2);
		    nodeD.addEdge(nodeH, 7);
		    nodeE.addEdge(nodeG, 6);
		    nodeF.addEdge(nodeG, 1);

		    ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		    Node result = algo1.execute(nodeS, "G");
		    
		

		    if (result != null) {
		        List<String> path = NodeUtils.printPath(result);
		        System.out.println("Path to G: " + String.join(" -> ", path));
		    } else {
		        System.out.println("Path to G not found.");
		    }
		    
		    ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		    Node result2 = algo2.execute(nodeS, "G");
		    
		    if (result2 != null) {
		        List<String> path2 = NodeUtils.printPath(result2);
		        System.out.println("Path to G: " + String.join(" -> ", path2));
		    } else {
		        System.out.println("Path to G not found.");
		    }
		}
	
	


	}


