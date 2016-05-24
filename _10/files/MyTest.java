import org.junit.Test;
import static org.junit.Assert.*;


public class MyTest {
	MyGraph graph;
	public MyTest(){
		graph = new MyGraph(12);
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
	}

  @Test
  public void testDFSStack() {
    graph.initVisited();
    graph.dfsStack(0);
    assertEquals(true, graph.getTraversal().equals("0>8>4>2>5>7>9>1>3>6>10>"));
  }
  @Test
  public void testDFSRecursive(){
  	graph.initVisited();
	graph.dfs(0);
	assertEquals(true, graph.getTraversal().equals("0>8>4>2>5>7>9>1>3>6>10>"));
	
  }
  @Test
  public void testBFS(){
  	graph.bfs(0);
	assertEquals(true, graph.getTraversal().equals("0>8>4>6>10>2>5>7>9>1>3>"));
  }

  @Test
  public void testIsConnected(){
  	assertEquals(false, graph.isConnected(1,11));
  	assertEquals(true, graph.isConnected(1,10));
  }
} 
