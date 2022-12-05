import java.util.*;

class Program {
  public static final String EAST = "EAST";
  public static final String WEST = "WEST";

  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    // Write your code here.
    int max = Integer.MIN_VALUE;
    ArrayList<Integer> buildingsLst = new ArrayList<>();
    
    if (EAST.equals(direction)) {
      for (int i = buildings.length - 1; i >= 0; i--) {
        if (buildings[i] > max) {
          buildingsLst.add(i);
          max = buildings[i];
        }
      }
      Collections.reverse(buildingsLst);
    } else {
      for (int i = 0; i < buildings.length; i++) {
        if (buildings[i] > max) {
          buildingsLst.add(i);
          max = buildings[i];
        }
      }
    }
    
    return buildingsLst;
  }
}

