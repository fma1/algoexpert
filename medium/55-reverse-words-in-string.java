import java.util.*;

class Program {
  public enum State { WHITESPACE, ALPHANUMERIC }

  public String reverseWordsInString(String string) {
    // Write your code here.
    StringBuilder sb = new StringBuilder();
    Stack<String> stack = new Stack<String>();
    State prevState = null;

    for (int i = 0; i < string.length(); i++) {
      char ch = string.charAt(i);
      State currState = ch == ' ' ? State.WHITESPACE : State.ALPHANUMERIC;
      prevState = prevState == null ? currState : prevState;

      if (prevState != currState) {
        stack.push(sb.toString());
        sb.setLength(0);
      }

      sb.append(ch);
      prevState = currState;
    }

    if (sb.length() > 0) {
      stack.push(sb.toString());
    }

    sb.setLength(0);
    System.out.println(stack.toString());

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    
    return sb.toString();
  }
}

