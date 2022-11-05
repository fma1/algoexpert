import java.util.*;

class Program {
  static class Tuple {
    public int number;
    public BST node;

    public Tuple(int number, BST node) {
      this.number = number;
      this.node = node;
    }
  }
  
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
      
      return this;
    }

    public boolean contains(int value) {
      // Write your code here.
      if (value == this.value) {
        return true;
      } else {
        if (value < this.value) {
          if (this.left != null) {
            return left.contains(value);
          } else {
            return false;
          }
        } else {
          if (this.right != null) {
            return right.contains(value);
          } else {
            return false;
          }
        }
      }
    }

    static int findLowestInRightTree(BST node, int lowest) {
      if (node.value < lowest) {
        lowest = node.value;
      }

      if (node.left != null) {
        return findLowestInRightTree(node.left, lowest);
      } else {
        return lowest;
      }
    }

    public void remove(int value, BST parent) {
      if (value < this.value) {
        if (left != null) {
          left.remove(value, this);
        }
      } else if (value > this.value) {
        if (right != null) {
          right.remove(value, this);
        }
      } else {
        if (left != null && right != null) {
            this.value = findLowestInRightTree(right, Integer.MAX_VALUE);
            right.remove(this.value, this);
        } else if (parent == null) {
          if (left != null) {
            this.value = left.value;
            this.right = left.right;
            this.left = left.left;
          } else if (right != null) {
            this.value = right.value;
            this.left = right.left;
            this.right = right.right;
          } else {
            
          }
        } else if (parent.left == this) {
          parent.left = left != null ? left : right;
        } else if (parent.right == this) {
          parent.right = right != null ? right : left;
        }
      }
    }

    public BST remove(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
      remove(value, null);
      return this;
    }
  }
}

