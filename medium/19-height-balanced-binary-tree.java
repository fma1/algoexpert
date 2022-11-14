import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  static class Tuple {
    public int height;
    public boolean isBalanced;

    public Tuple(int height, boolean isBalanced) {
      this.height = height;
      this.isBalanced = isBalanced;
    }
  }

  public Tuple heightBBTRec(BinaryTree tree, int height) {
    if (tree.left == null && tree.right == null) {
      return new Tuple(height, true);
    }
    
    boolean hasLeft = tree.left != null;
    boolean hasRight = tree.right != null;

    Tuple tupLeft = null;
    Tuple tupRight = null;
    boolean isBalanced = false;

    if (hasLeft) {
      tupLeft = heightBBTRec(tree.left, 1);
    }
    if (hasRight) {
      tupRight = heightBBTRec(tree.right, 1);
    }

    int leftHeight = hasLeft ? tupLeft.height : 0;
    int rightHeight = hasRight ? tupRight.height : 0;
    boolean leftBool = hasLeft ? tupLeft.isBalanced : true;
    boolean rightBool = hasRight ? tupRight.isBalanced : true;

    height += Math.max(leftHeight, rightHeight);
    isBalanced = !leftBool || !rightBool ? false : Math.abs(leftHeight - rightHeight) <= 1;

    return new Tuple(height, isBalanced);
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
    if (tree == null || tree.left == null && tree.right == null) {
      return true;
    } else {
      Tuple tuple = heightBBTRec(tree, 0);
      return tuple.isBalanced;
    }
  }
}

