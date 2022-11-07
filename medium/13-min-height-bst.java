import java.util.*;

class Program {
  static BST minHeightBstRec(List<Integer> array, BST root, int l, int r) {
    int mid = l + (r - l)/2;

    if (l > r) {
      return root;
    }
    
    if (root == null) {
      if (l - r + 1 == 2) {
        root = new BST(array.get(l));
        root.insert(array.get(r));
      } else {
        root = new BST(array.get(mid));
        minHeightBstRec(array, root, l, mid - 1);
        minHeightBstRec(array, root, mid + 1, r);
      }
    } else {
      if (l == r) {
        root.insert(array.get(l));
      } else {
        root.insert(array.get(mid));
        minHeightBstRec(array, root, l, mid - 1);
        minHeightBstRec(array, root, mid + 1, r);
      }
    }

    return root;
  }
  
  public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
    return minHeightBstRec(array, null, 0, array.size() - 1);
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
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
    }
  }
}

