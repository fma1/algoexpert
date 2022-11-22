import java.util.*;

class Program {
  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int hashCode() {
      return Integer.hashCode(x) + Integer.hashCode(y);
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      } else if (o == null || !(o instanceof Point)) {
        return false;
      } else {
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
      }
    }

    public String toString() {
      return String.format("Point(%d, %d)", x, y);
    }
  }

  static int getPoint(Point point, int[][] matrix) {
    int retVal = point.x >= 0 && point.x < matrix.length && 
      point.y >= 0 && point.y < matrix[0].length ? 
      matrix[point.x][point.y] : -1;
    return retVal;
  }

  static int DFS(Point point, int[][] matrix, Set<Point> visited, Set<Point> unvisited) {
    int size = 0;

    visited.add(point);
    unvisited.remove(point);

    if (getPoint(point, matrix) == 1) { 
      Point abovePoint = new Point(point.x, point.y - 1);
      Point belowPoint = new Point(point.x, point.y + 1);
      Point leftPoint = new Point(point.x - 1, point.y);
      Point rightPoint = new Point(point.x + 1, point.y);

      if (abovePoint.y >= 0 && !visited.contains(abovePoint)) {
        size += DFS(abovePoint, matrix, visited, unvisited);
      }
      if (belowPoint.y < matrix[0].length && !visited.contains(belowPoint)) {
        size += DFS(belowPoint, matrix, visited, unvisited);
      }
      if (leftPoint.x >= 0 && !visited.contains(leftPoint)) {
        size += DFS(leftPoint, matrix, visited, unvisited);
      }
      if (rightPoint.x < matrix.length && !visited.contains(rightPoint)) {
        size += DFS(rightPoint, matrix, visited, unvisited);
      }

      size++;
    }

    return size;
  }
  
  public static List<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
    Set<Point> visited = new HashSet<>();
    Set<Point> unvisited = new HashSet<>();
    List<Integer> sizes = new ArrayList<Integer>();

    for (int x = 0; x < matrix.length; x++) {
      for (int y = 0; y < matrix[0].length; y++) {
        unvisited.add(new Point(x, y));
      }
    }

    while (!unvisited.isEmpty()) {
      Point point = visited.isEmpty() ? new Point(0, 0) : unvisited.iterator().next();
      int value = getPoint(point, matrix);
      
      if (value == 1) {
        sizes.add(DFS(point, matrix, visited, unvisited));
      } else if (value == 0) {
        visited.add(point);
        unvisited.remove(point);
      } else {
        // Point out of bounds
      }
    }
    
    return sizes;
  }
}

