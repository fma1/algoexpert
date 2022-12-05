import java.util.*;

class Program {
  public static final Map<Character, Character> closingToOpeningMap = 
    Map.of(')', '(', ']', '[', '}', '{');
  
  public static boolean balancedBrackets(String str) {
    // Write your code here.
    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
      if (closingToOpeningMap.containsKey(ch)) {
        if (stack.isEmpty()) {
          return false;
        } else {
          if (!closingToOpeningMap.get(ch).equals(stack.pop())) {
            return false;
          }
        }
      } else {
        stack.push(ch);
      }
    }

    if (!stack.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}

