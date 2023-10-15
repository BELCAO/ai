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
		    
		    ISearchAlgo breadthFirstSearchAlgo = new BreadthFirstSearchAlgo();
	        Node resultBread = breadthFirstSearchAlgo.execute(nodeS, "G");
	        if (resultBread != null) {
	        	System.out.println("BreadthFirstSearchAlgo: ");
	            List<String> path = NodeUtils.printPath(resultBread);
	            System.out.println(nodeS.getLabel() + " den G: " + String.join(" -> ", path)
	            +" Tong chi phi: " + resultBread.getPathCost());
	        } 
	        ISearchAlgo depthFirstSearchAlgo = new DepthFirstSearchAlgo();
	        Node resultDepth = depthFirstSearchAlgo.execute(nodeS, "G");
	        if (resultDepth != null) {
	        	System.out.println("DepthFirstSearchAlgo: ");
	            List<String> path = NodeUtils.printPath(resultDepth);
	            System.out.println(nodeS.getLabel() + " den G: " + String.join(" -> ", path)
	            +" Tong chi phi: " + resultDepth.getPathCost());
	        } 
	      

		    ISearchAlgo uniformCostSearchAlgo = new UniformCostSearchAlgo();
	        Node resultUni = uniformCostSearchAlgo.execute(nodeS, "G");
	        if (resultUni != null) {
	        	System.out.println("UniformCostSecarch: ");
	            // In đường dẫn
	            List<String> path = NodeUtils.printPath(resultUni);
	            System.out.println(nodeS.getLabel() + " den G: " + String.join(" -> ", path)
	            +" Tong chi phi: " + resultUni.getPathCost());
	        } 
	     // In your Test class main method
	        DepthLimitedSearchAlgo depthLimitedSearchAlgo = new DepthLimitedSearchAlgo();
	        int limitedDepth = 3;  // Set your desired depth limit
	        Node resultDepthLimited = depthLimitedSearchAlgo.execute(nodeS, "G", limitedDepth);
	        System.out.println("DepthLimitedSearchAlgo: ");
	        if (resultDepthLimited != null) {
	            List<String> path = NodeUtils.printPath(resultDepthLimited);
	            System.out.println(nodeS.getLabel() + " to G: " + String.join(" -> ", path)
	                + " Total cost: " + resultDepthLimited.getPathCost() + " within depth: " + limitedDepth);
	        } else {
	            System.out.println("No path found to G within depth " + limitedDepth);
	        }

	        
	        
	       
	    }
	    
	    
	
	    }
	 
		
	
	




