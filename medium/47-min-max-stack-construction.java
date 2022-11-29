import java.util.*;

class Program {
  // Feel free to add new properties and methods to the class.
  static class MinMaxStack {
    List<Integer> backingList = new ArrayList<Integer>();
    List<Integer> minList = new ArrayList<Integer>();
    List<Integer> maxList = new ArrayList<Integer>();

    public int getLastIdx() {
      return backingList.size() - 1;
    }
    
    public int peek() {
      // Write your code here.
      return backingList.get(getLastIdx());
    }

    public int pop() {
      // Write your code here.
      int lastIdx = getLastIdx();
      minList.remove(lastIdx);
      maxList.remove(lastIdx);
      return backingList.remove(lastIdx);
    }

    public void push(Integer number) {
      // Write your code here.
      if (minList.isEmpty()) {
        minList.add(number);
        maxList.add(number);
      } else {
        int lastIdx = getLastIdx();
        int newMin = number < minList.get(lastIdx) ? number : minList.get(lastIdx);
        int newMax = number > maxList.get(lastIdx) ? number : maxList.get(lastIdx);
        minList.add(newMin);
        maxList.add(newMax);
      }

      backingList.add(number);
    }

    public int getMin() {
      // Write your code here.
      return minList.get(getLastIdx());
    }

    public int getMax() {
      // Write your code here.
      return maxList.get(getLastIdx());
    }
  }
}

