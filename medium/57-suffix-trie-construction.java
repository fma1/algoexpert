import java.util.*;

class Program {
  // Do not edit the class below except for the
  // populateSuffixTrieFrom and contains methods.
  // Feel free to add new properties and methods
  // to the class.
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      // Write your code here.
      TrieNode curr = null;
      String suffix = null;

      for (int i = str.length() - 1; i >= 0; i--) {
        curr = root;
        suffix = str.substring(i, str.length());
        for (int j = 0; j < suffix.length(); j++) {
          char ch = suffix.charAt(j);
          if (curr.children.containsKey(ch)) {
            curr = curr.children.get(ch);
          } else {
            TrieNode newNode = new TrieNode();
            curr.children.put(ch, newNode);
            curr = newNode;
          }
        }

        curr.children.put(endSymbol, null);
      }
    }

    public boolean contains(String str) {
      // Write your code here.
      TrieNode curr = root;
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (curr.children.containsKey(ch)) {
          curr = curr.children.get(ch);
        } else {
          return false;
        }
      }
      return curr != null && curr.children.containsKey(endSymbol);
    }
  }
}

