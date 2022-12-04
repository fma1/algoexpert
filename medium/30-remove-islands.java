import java.util.*;

class Program {
  class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int hashCode() {
      return Integer.hashCode(x) + Integer.hashCode(y);
    }

    public boolean equals(Object o) {
      if (o instanceof Coordinate) {
        Coordinate c = (Coordinate) o;
        return this.x == c.x && this.y == c.y;
      } else {
        return false;
      }
    }
  }
  
  public void changeBorderOnes(Coordinate coord, int[][] matrix, Set<Coordinate> visited, Set<Coordinate> unvisited) {
    if (!visited.contains(coord) && matrix[coord.x][coord.y] == 1) {
      matrix[coord.x][coord.y] = -1;
      unvisited.remove(coord);
      visited.add(coord);

      int left = coord.x - 1;
      int right = coord.x + 1;
      int up = coord.y - 1;
      int down = coord.y + 1;

      if (up >= 0) {
        changeBorderOnes(new Coordinate(coord.x, up), matrix, visited, unvisited);
      }
      if (down < matrix[0].length) {
        changeBorderOnes(new Coordinate(coord.x, down), matrix, visited, unvisited);
      }
      if (left >= 0) {
        changeBorderOnes(new Coordinate(left, coord.y), matrix, visited, unvisited);
      }
      if (right < matrix.length) {
        changeBorderOnes(new Coordinate(right, coord.y), matrix, visited, unvisited);
      }
    }    
  }

  public int[][] removeIslands(int[][] matrix) {
    // Write your code here.
    Set<Coordinate> visited = new HashSet<>();
    Set<Coordinate> unvisited = new HashSet<>();
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        unvisited.add(new Coordinate(i, j));
      }
    }

    for (int y = 0; y < matrix[0].length; y++) {
      changeBorderOnes(new Coordinate(0, y), matrix, visited, unvisited);
    }

    for (int y = 0; y < matrix[0].length; y++) {
      changeBorderOnes(new Coordinate(matrix.length - 1, y), matrix, visited, unvisited);
    }

    for (int x = 0; x < matrix.length; x++) {
      changeBorderOnes(new Coordinate(x, 0), matrix, visited, unvisited);
    }

    for (int x = 0; x < matrix.length; x++) {
      changeBorderOnes(new Coordinate(x, matrix[0].length - 1), matrix, visited, unvisited);
    }

    for (Coordinate coord : unvisited) {
      if (matrix[coord.x][coord.y] == 1) {
        matrix[coord.x][coord.y] = 0;
      }
    }

    for (Coordinate coord : visited) {
      if (matrix[coord.x][coord.y] == -1) {
        matrix[coord.x][coord.y] = 1;
      }
    }

    return matrix;
  }
}

