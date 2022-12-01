import java.util.*;

class Program {

  public char[] minimumCharactersForWords(String[] words) {
    // Write your code here.
    Map<Character, Integer> globalCharCount = new HashMap<>();
    List<Character> resultLst = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (String word : words) {
      Map<Character, Integer> localCharCount = new HashMap<>();
      for (char ch : word.toCharArray()) {
        if (localCharCount.containsKey(ch)) {
          localCharCount.put(ch, localCharCount.get(ch) + 1);
        } else {
          localCharCount.put(ch, 1);
        }
      }

      for (char ch : localCharCount.keySet()) {
        if ((globalCharCount.containsKey(ch) && 
             localCharCount.get(ch) > globalCharCount.get(ch)) ||
            !globalCharCount.containsKey(ch)) {
            globalCharCount.put(ch, localCharCount.get(ch));
        }
      }
    }

    globalCharCount.forEach((ch, count) -> {
      for (int i = 0; i < count; i++) {
        sb.append(ch);
      }
    });
    
    return sb.toString().toCharArray();
  }
}
