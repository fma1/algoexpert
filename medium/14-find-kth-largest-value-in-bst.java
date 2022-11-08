import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  void findKthRec(BST root, List<Integer> lst, int k) {
    if (lst.size() == k) return;

    if (root.right != null) {
      findKthRec(root.right, lst, k);
    }

    lst.add(root.value);

    if (root.left != null) {
      findKthRec(root.left, lst, k);
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    // Write your code here.
    List<Integer> lst = new ArrayList<>();

    findKthRec(tree, lst, k);
    
    return lst.get(k - 1);
  }
}

