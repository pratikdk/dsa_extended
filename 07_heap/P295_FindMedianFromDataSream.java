import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Long> maxHeap;
    PriorityQueue<Long> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // first half
        minHeap = new PriorityQueue<>(); // second half
    }
    
    public void addNum(int num) {
        minHeap.add((long) num);
        maxHeap.add(minHeap.poll());
        if (minHeap.size() < maxHeap.size()) { // hence we have min heap size >= max heap
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        return (minHeap.size() > maxHeap.size()) ? minHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

public class P295_FindMedianFromDataSream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr = r[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}
