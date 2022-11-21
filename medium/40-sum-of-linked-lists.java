import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    // Write your code here.
    LinkedList first, second, head, curr, temp;
    int sum, carry;
    
    first = linkedListOne;
    second = linkedListTwo;
    head = curr = null;
    carry = 0;

    while (first != null || second != null) {
      boolean hasFirst = first != null;
      boolean hasSecond = second != null;

      sum = carry;
      carry = 0;
      
      if (hasFirst && hasSecond) {
        sum += first.value + second.value;
        if (sum >= 10) {
          sum -= 10;
          carry = 1;
        }
      } else {
        if (hasFirst) {
          sum += first.value;
        } else {
          sum += second.value;
        }
      }

      temp = new LinkedList(sum);
      if (head == null) {
        head = curr = temp;
      } else {
        curr.next = temp;
        curr = curr.next;
      }

      first = hasFirst ? first.next : null;
      second = hasSecond ? second.next : null;
    }

    // Edge case
    if (carry == 1) {
      curr.next = new LinkedList(1);
    }
    
    return head;
  }
}

