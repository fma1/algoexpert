import java.util.*;

class Program {
  public int staircaseTraversal(int height, int maxSteps) {
    // Write your code here.
    Map<Integer, Integer> dp = new HashMap<>();

    dp.put(0, 1);
    dp.put(1, 1);

    for (int currHeight = 2; currHeight <= height; currHeight++) {
      int sum = 0;
      for (int i = 1; i <= maxSteps; i++) {
        sum += dp.containsKey(currHeight - i) ? dp.get(currHeight - i) : 0;
      }
      dp.put(currHeight, sum);
    }
    
    return dp.get(height);
  }
}

