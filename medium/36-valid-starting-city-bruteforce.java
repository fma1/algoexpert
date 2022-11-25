import java.util.*;

class Program {

  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    // Write your code here.
    for (int startingCity = 0; startingCity < distances.length; startingCity++) {
      int nextCity = startingCity == distances.length - 1 ? 0 : startingCity + 1;
      int currFuel = fuel[startingCity] * mpg;
      boolean notEnoughFuel = false;

      for (int counter = 0; counter < distances.length - 1; counter++) {
        if (nextCity == distances.length) {
          nextCity = 0;
        }

        int gallonsUsed = nextCity != 0 ? distances[nextCity - 1] : distances[distances.length - 1];
        currFuel -= gallonsUsed;

        if (currFuel < 0) {
          notEnoughFuel = true;
        }

        currFuel += fuel[nextCity] * mpg;
        nextCity++;
      }

      if (!notEnoughFuel && currFuel >= 0) {
        return startingCity;
      }
    }
    
    return -1;
  }
}

