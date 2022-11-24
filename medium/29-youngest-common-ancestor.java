import java.util.*;

class Program {
  static int getDepth(AncestralTree node) {
    Stack<AncestralTree> stack = new Stack<>();
    int depth = 0;
    
    stack.add(node);

    while (!stack.isEmpty()) {
      node = stack.pop();
      depth++;

      if (node.ancestor != null) {
        stack.push(node.ancestor);
      }
    }

    return depth;
  }
  
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    // Write your code here.

    int depthOne = getDepth(descendantOne);
    int depthTwo = getDepth(descendantTwo);
    int diff = Math.abs(depthOne - depthTwo);

    if (depthOne > depthTwo) {
      for (int i = 0; i < diff; i++) {
        descendantOne = descendantOne.ancestor;
      }
    } else if (depthOne < depthTwo) {
      for (int i = 0; i < diff; i++) {
        descendantTwo = descendantTwo.ancestor;
      }
    } else {
      
    }

    while (descendantOne != null && descendantTwo != null && descendantOne != descendantTwo) {
      descendantOne = descendantOne.ancestor;
      descendantTwo = descendantTwo.ancestor;
    }
    
    AncestralTree commonAncestor = descendantOne == descendantTwo ? descendantOne : 
                                                                    topAncestor;
    return commonAncestor;
  }

  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }

    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }
}

