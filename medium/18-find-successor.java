import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findRightSuccessor(BinaryTree tree) {
    if (tree.left == null) {
      return tree;
    } else {
      return findRightSuccessor(tree.left);
    }
  }
  
  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
    if (node.right != null) {
      return findRightSuccessor(node.right);
    } else {
      if (node.parent == null) {
        return null;
      } else if (node.parent.right == node) {
        return node.parent.parent;
      } else {
        return node.parent;
      }
    }
  }
}

