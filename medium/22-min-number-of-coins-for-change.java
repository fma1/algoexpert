import java.util.*;

class Program {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.

    int len = n + 1;
    int[] minCoins = new int[len];
    Arrays.fill(minCoins, Integer.MAX_VALUE);
    minCoins[0] = 0;

    Arrays.sort(denoms);

    for (int coin : denoms) {
      for (int amt = 0; amt < len; amt++) {
        if (coin <= amt) {
          int compVal = minCoins[amt - coin];
          if (compVal != Integer.MAX_VALUE) {
            compVal++;
          }
          minCoins[amt] = Math.min(minCoins[amt], compVal);
        }
      }
    }
  
    return minCoins[n] != Integer.MAX_VALUE ? minCoins[n] : -1;
  }
}

