import java.util.*;

class Program {
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    // Write your code here.
    int len = n + 1;
    int[] dp = new int[len];
    Arrays.fill(dp, 0);
    dp[0] = 1;


    for (int coin : denoms) {
      for (int amt = 0; amt < len; amt++) {
        if (coin <= amt) {
          dp[amt] += dp[amt - coin];
        }
      }
    }
    
    return dp[n];
  }
}

