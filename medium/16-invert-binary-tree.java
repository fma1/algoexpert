import java.util.*;

class Program {
  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
    BinaryTree temp;
    if (tree.left != null && tree.right != null) {
      temp = tree.left;
      tree.left = tree.right;
      tree.right = temp;

      invertBinaryTree(tree.left);
      invertBinaryTree(tree.right);
    } else {
      if (tree.left != null) {
        temp = tree.left;
        tree.left = null;
        tree.right = temp;

        invertBinaryTree(temp);
      } else if (tree.right != null) {
        temp = tree.right;
        tree.right = null;
        tree.left = temp;

        invertBinaryTree(temp);
      } else {
        
      }
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

