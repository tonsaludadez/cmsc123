import java.util.Stack;
import java.util.LinkedList;
import java.util.Iterator;


class MyGraph{
	protected boolean[][] adjMatrix;
	protected boolean[] visited;
	protected int vertices;
	protected int edges;
	protected LinkedList traversals; //stores the nodes traversed

	MyGraph(int vertices){
		this.vertices = vertices;
		edges = 0;
		adjMatrix = new boolean[vertices][vertices];
		for (int i=0; i<adjMatrix.length; i++ ) {
			for (int j=0; j<adjMatrix.length ;j++ ) {
				adjMatrix[i][j] = false;
			}
		}
		initVisited();
		traversals = new LinkedList();
	}
	public void initVisited(){
		visited  = new boolean[vertices];
		for (int i=0;i<visited.length ;i++ ) {
			visited[i] = false;
		}
		traversals = new LinkedList();
	}

	public boolean validVertex(int v){
		return (v>=0) && (v<vertices);
	}

	public boolean hasEdge(int origin, int destination){
		if(validVertex(origin) && validVertex(destination)){
			return adjMatrix[origin][destination];
		}else{
			return false;
		}
	}

	public void addEdge(int origin, int destination){
		if(validVertex(origin) && validVertex(destination)){
			if(!adjMatrix[origin][destination]){
				adjMatrix[origin][destination] = true;
				edges++;
			}
		}
	}

	public void removeEdge(int origin, int destination){
		if(validVertex(origin) && validVertex(destination)){
			if(adjMatrix[origin][destination]){
				adjMatrix[origin][destination] = false;
				edges--;
			}
		}
	}

	public String toString(){
		String s = vertices + " vertices and "+ edges+" edges\n";
		int i,j=0;
		for (i=0; i<vertices; i++ ) {
			for (j=0; j<vertices-1; j++ ) {
				s = s + (adjMatrix[i][j]? "1":".") + " ";
			}
			s = s + (adjMatrix[i][j]? "1":".") + "\n";
			
		}
		return s;
	}

	public void dfs(int vertex){
		visited[vertex] = true;
		traversals.addFirst(vertex);
		int i=0;
		while(i<vertices){
			if(adjMatrix[vertex][i]){
				if(!visited[i])
					dfs(i);
			}
			i++;
		}
	}
	public void dfsStack(int vertex){
		//fill in your solution here

		// make a stack
		Stack<Integer> temp = new Stack<Integer>();

		//push the parameter to the stack
		temp.push(vertex);
		//add it to the traversals list
		traversals.addFirst(vertex);
		//set its status to visited
		visited[vertex] = true;

		//while the stack isnt empty yet-- meaning our job isnt done yet
		while (!temp.isEmpty()) {
			// assign the peek to a variable
			int u = temp.peek();
			int i = 0;

			for (i = 0; i < vertices; i++) {

				//check the edges of the vertex on the top of the stack
				if (adjMatrix[u][i] && !visited[i]) {
					visited[i] = true;
					traversals.addFirst(i);
					temp.push(i);
					break;
				}
			}

			// if it has traversed the entire edges, then we pop the top vertex.
			if (i == vertices) {
				temp.pop();
			}
		}
	}

	public void bfs(int u){
	// set the status of vertex u as true -- meaning it's already visited
		visited[u] = true;

		// temporary stack to store the edges of u
		LinkedList<Integer> temp = new LinkedList<Integer>();

		traversals.add(u);
		temp.addFirst(u);
		int row = u;

		while (!temp.isEmpty()) {
			row = temp.removeLast();					// dequeue
			for (int i = 0; i < vertices; i++) {		// check its edges
				if(adjMatrix[row][i] && !visited[i]) {	// if the current vertex is an edge of u and it hasn't been visited yet,
					traversals.addFirst(i);				// add to the traversals list
					temp.addFirst(i);					// add to our temporary list of edges
					visited[i] = true;					//mark this as visited
				}
			}
		}
	
	}
	public boolean isConnected(int a, int b){
		LinkedList<Integer> temp = new LinkedList<Integer>();

		temp.addFirst(a);
		int row = a;

		while (!temp.isEmpty()) {
			row = temp.removeLast();					// dequeue
			for (int i = 0; i < vertices; i++) {		// check its edges
				if(adjMatrix[row][i] && !visited[i]) {	// if the current vertex is an edge of u and it hasn't been visited yet,
					
					 if(i == b){
						return true;
					}

					temp.addFirst(i);					// add to our temporary list of edges
					visited[i] = true;					//mark this as visited
				}
			}
		}
		return false;
	}
	public String getTraversal(){
		String s = "";
		while(!traversals.isEmpty()){
			s = s + traversals.removeLast()+">";
		}
		return s;
	}
	public static void main(String[] args) {
		MyGraph graph = new MyGraph(12);
	    graph.addEdge(0, 8);
	    graph.addEdge(1, 0);
	    graph.addEdge(1, 3);
	    graph.addEdge(2, 0);
	    graph.addEdge(3, 2);
	    graph.addEdge(3, 5);
	    graph.addEdge(4, 2);
	    graph.addEdge(4, 5);
	    graph.addEdge(5, 7);
	    graph.addEdge(5, 9);
	    graph.addEdge(6, 4);
	    graph.addEdge(6, 7);
	    graph.addEdge(8, 4);
	    graph.addEdge(8, 6);
	    graph.addEdge(8, 10);
	    graph.addEdge(9, 1);
	    graph.addEdge(10, 6);	

	    graph.initVisited();
    	graph.dfsStack(0);
    	System.out.println(graph.getTraversal().equals("0>8>4>2>5>7>9>1>3>6>10>") + " must be true");

    	graph.initVisited();
		graph.dfs(0);
		System.out.println(graph.getTraversal().equals("0>8>4>2>5>7>9>1>3>6>10>") + " must be true");

		graph.initVisited();
		graph.bfs(0);
		System.out.println(graph.getTraversal().equals("0>8>4>6>10>2>5>7>9>1>3>") + " must be true");

		graph.initVisited();
		System.out.println(graph.isConnected(1,11) +" must be false");
		graph.initVisited();
		System.out.println(graph.isConnected(1,10) +" must be true");

	}
}

