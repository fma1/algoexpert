import java.util.*;

class Program {

  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    // Write your code here.
    int minGas = Integer.MAX_VALUE;
    int minIdx = -1;
    int currGas = 0;

    for (int i = 0; i < distances.length; i++) {
      if (currGas < minGas) {
        minGas = currGas;
        minIdx = i;
      }
      
      currGas += fuel[i] * mpg - distances[i];
    }
    
    return minIdx;
  }
}

