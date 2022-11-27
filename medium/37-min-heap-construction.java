import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    private int getParentIdx(int idx) {
      return (idx - 1)/2;
    }

    private int getFirstChildIdx(int idx) {
      return 2*idx + 1;
    }

    private int getSecondChildIdx(int idx) {
      return 2*idx + 2;
    }

    private boolean hasChildren(int currentIdx, List<Integer> heap) {
      return 2*currentIdx + 1 < heap.size();
    }

    public void heapify(int currentIdx, List<Integer> array) {
      siftDown(currentIdx, array.size() - 1, array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      // Write your code here.
      for (int idx = array.size() - 1; idx >= 0; idx--) { 
		heapify(idx, array); 
      } 
      return array;
    }

    public void swap(int idx1, int idx2, List<Integer> heap) {
      int value1 = heap.get(idx1);
      int value2 = heap.get(idx2);
      heap.set(idx1, value2);
      heap.set(idx2, value1);
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      // Write your code here.
      int firstChildIdx = getFirstChildIdx(currentIdx);
      int secondChildIdx = getSecondChildIdx(currentIdx);
      int smallestIdx = currentIdx;

      if (firstChildIdx <= endIdx && heap.get(firstChildIdx) < heap.get(smallestIdx)) {
        smallestIdx = firstChildIdx;
      }
      if (secondChildIdx <= endIdx && heap.get(secondChildIdx) < heap.get(smallestIdx)) {
        smallestIdx = secondChildIdx;  
      }

      if (smallestIdx != currentIdx) {
        swap(currentIdx, smallestIdx, heap);
        heapify(smallestIdx, heap);
      }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      // Write your code here.
      while (currentIdx > 0) {
        int parentIdx = getParentIdx(currentIdx);

        if (heap.get(parentIdx) > heap.get(currentIdx)) {
          swap(currentIdx, parentIdx, heap);
        }

        currentIdx = parentIdx;
      }
    }

    public int peek() {
      // Write your code here.
      return heap.size() > 0 ? heap.get(0) : -1;
    }

    public int remove() {
      // Write your code here.
      int min = Integer.MAX_VALUE;
      int lastElem = Integer.MAX_VALUE;
      
      if (heap.size() == 0) {
        return -1;
      } else if (heap.size() == 1) {
        min = heap.get(0);
        heap.clear();
        return min;
      } else {
        min = heap.get(0);
        lastElem = heap.get(heap.size() - 1);
        
        heap.remove(heap.size() - 1);
        heap.set(0, lastElem);
        heapify(0, heap);
        
        return min;
      }
    }

    public void insert(int value) {
      // Write your code here.
      heap.add(value);
      siftUp(heap.size() - 1, heap);
    }
  }
}

