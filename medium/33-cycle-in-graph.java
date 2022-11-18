import java.util.*;

class Program {
  public boolean cycleInGraph(int[][] edges) {
    // Write your code here.
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    Set<Integer> stackSet = new Set<>();

    for (int i = 0; i < edges.length; i++) {
      visited.clear();
      stack.add(i);
      
      while (!stack.isEmpty()) {
        int vertex = stack.pop();
        System.out.println("vertex: " + vertex);

        if (visited.contains(vertex)) {
          System.out.println(vertex);
          return true;
        }

        for (int destVertex : edges[vertex]) {
          
        System.out.println("destVertex: " + destVertex);
          stack.add(destVertex);
        }
        
        visited.add(vertex);
      }
    }
    
    return false;
  }
}

