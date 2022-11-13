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
    public int diameter;

    public Tuple(int height, int diameter) {
      this.height = height;
      this.diameter = diameter;
    }
  }

  public Tuple binaryTreeDiameterRec(BinaryTree tree, int height) {
    if (tree.left == null && tree.right == null) {
      return new Tuple(height, 0);
    }

    boolean hasLeft = tree.left != null;
    boolean hasRight = tree.right != null;

    Tuple tupLeft = hasLeft ? binaryTreeDiameterRec(tree.left, 1) : null;
    Tuple tupRight = hasRight ? binaryTreeDiameterRec(tree.right, 1) : null;

    int leftDiameter = hasLeft ? tupLeft.diameter : 0;
    int rightDiameter = hasRight ? tupRight.diameter : 0;
    int leftHeight = hasLeft ? tupLeft.height : 0;
    int rightHeight = hasRight ? tupRight.height : 0;
    
    int diameter = Math.max(
      Math.max(leftDiameter, rightDiameter), 
      leftHeight + rightHeight);

    return new Tuple(height + Math.max(leftHeight, rightHeight), diameter);
  }

  public int binaryTreeDiameter(BinaryTree tree) {
    // Write your code here.
    if (tree == null) return -1;
    Tuple tuple = binaryTreeDiameterRec(tree, 0);
    return tuple.diameter;
  }
}
