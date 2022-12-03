import java.util.*;

class Program {
  Map<Character, List<Character>> keypad =
    Map.of('0', List.of('0'),
           '1', List.of('1'),
           '2', List.of('a', 'b', 'c'),
           '3', List.of('d', 'e', 'f'),
           '4', List.of('g', 'h', 'i'),
           '5', List.of('j', 'k', 'l'),
           '6', List.of('m', 'n', 'o'),
           '7', List.of('p', 'q', 'r', 's'),
           '8', List.of('t', 'u', 'v'),
           '9', List.of('w', 'x', 'y', 'z'));

  private void phoneNumberMnemonicsHelper(String acc, String rest, ArrayList<String> mnemonicsLst) {
    if (rest.isEmpty()) {
      mnemonicsLst.add(acc);
    } else {
      List<Character> letters = keypad.get(rest.charAt(0));
      rest = rest.substring(1, rest.length());

      for (char letter : letters) {
        phoneNumberMnemonicsHelper(acc + letter, rest, mnemonicsLst);
      }
    }
  }

  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    // Write your code here.
    ArrayList<String> mnemonicsLst = new ArrayList<String>();
    phoneNumberMnemonicsHelper("", phoneNumber.trim(), mnemonicsLst);
    return mnemonicsLst;
  }
}

