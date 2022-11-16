import java.util.*;

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    // Write your code here.
    if (array.length == 0) {
      return 0;
    }
    
    int minusTwo = 0;
    int minusOne = 0;
    int temp = -1;
    
    for (int i = 0; i < array.length; i++) {
      temp = Math.max(minusTwo + array[i], minusOne);
      minusTwo = minusOne;
      minusOne = temp;
    }
    
    return temp;
  }
}

