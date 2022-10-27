import java.util.*;

class Program {
  static boolean validateBstRec(BST tree, int min, int max) {
    if (tree.value < min || tree.value >= max) {
      return false;
    } else {
      boolean leftCheck = true;
      boolean rightCheck = true;

      if (tree.right != null) {
        rightCheck = validateBstRec(tree.right, tree.value, max);
      }
      if (tree.left != null) {
        leftCheck = validateBstRec(tree.left, min, tree.value);
      }

      return rightCheck && leftCheck;
    }
  }
  
  public static boolean validateBst(BST tree) {
    // Write your code here.
    return validateBstRec(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}

