import java.util.*;

class Program {
  class ThreeComparator implements Comparator<Integer> {
    int[] order;

    public ThreeComparator(int[] order) {
      this.order = order;
    }

    private int getIdx(Integer o) {
      for (int i = 0; i < order.length; i++) {
        if (order[i] == o) {
          return i;
        }
      }

      return Integer.MIN_VALUE;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      return Integer.compare(getIdx(o1), getIdx(o2));
    }
  }
  
  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
    ThreeComparator comparator = new ThreeComparator(order);
    // Only taking O(n) space due to generics not working with primitives
    // Technically should be O(n) runtime and O(1) space
    Integer[] input = Arrays.stream(array).boxed().toArray(Integer[]::new);

    Arrays.sort(input, comparator);
    
    return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
  }
}
