import java.util.*;

class Program {
  static class Task implements Comparable<Task> {
    int index;
    int value;

    public Task(int index, int value) {
      this.value = value;
      this.index = index;
    }

    public int compareTo(Task o) {
      return Integer.compare(this.value, o.value);
    }
  }

  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    // Write your code here.
    LinkedList<Task> tasks2 = new LinkedList<>();
    ArrayList<ArrayList<Integer>> taskPairs = new ArrayList<>();

    for (int i = 0; i < tasks.size(); i++) {
      tasks2.add(new Task(i, tasks.get(i)));
    }

    Collections.sort(tasks2);

    for (int i = 0; i < k; i++) {
      ArrayList<Integer> pair = new ArrayList<>();
      pair.add(tasks2.removeFirst().index);
      pair.add(tasks2.removeLast().index);
      taskPairs.add(pair);
    }

    System.out.println(taskPairs);
    
    return taskPairs;
  }
}

