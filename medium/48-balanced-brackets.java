import java.util.*;

class Program {
  public static final Map<Character, Character> closingToOpeningMap = 
    Map.of(')', '(', ']', '[', '}', '{');
  public static final Set<Character> openingChars =
    Set.of('(', '[', '{');
  public static final Set<Character> closingChars =
    closingToOpeningMap.keySet();
  
  public static boolean balancedBrackets(String str) {
    // Write your code here.
    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
      if (closingChars.contains(ch)) {
        if (stack.isEmpty()) {
          return false;
        } else {
          if (!closingToOpeningMap.get(ch).equals(stack.pop())) {
            return false;
          }
        }
      } else if (openingChars.contains(ch)) {
        stack.push(ch);
      } else {
        
      }
    }

    if (!stack.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}

