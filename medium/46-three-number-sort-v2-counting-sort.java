import java.util.*;

class Program {
  public int getIdx(int num, int[] order) {
    for (int i = 0; i < order.length; i++) {
      if (order[i] == num) {
        return i;
      }
    }

    return Integer.MIN_VALUE;
  }
  
  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
    int[] counts = new int[order.length];

    counts[0] = 0;
    counts[1] = 0;
    counts[2] = 0;
    
    for (int i = 0; i < array.length; i++) {
      counts[getIdx(array[i], order)]++;
    }

    counts[1] += counts[0];
    counts[2] += counts[1];

    for (int i = 0; i < order.length; i++) {
      for (int j = i - 1 >= 0 ? counts[i-1] : 0; j < counts[i]; j++) {
        array[j] = order[i];
      }
    }
  
    return array;
  }
}

