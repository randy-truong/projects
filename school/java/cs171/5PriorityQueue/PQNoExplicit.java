// Name: Randy Truong
// CS 171

package Assignment5;

public class PQNoExplicit {

    // Program status: INCOMPLETE
    /* My approach for a Priority Queue without Explicit Links:
    We use two arrays with each array representing a heap. One heap is the minHeap where
    the root (index 1 of array) is the lowest number and the last item (last index) is the
    greatest number. Another heap is the maxHeap where the root (index 1 of array) is the
    greatest number and the last item (last index of array) is the lowest number. With
    a MinMaxPriorityQueue, we can access the minimum and maximum values quickly with O(lgn)
    time complexity because each we are taking the minimum from the minHeap and the
    maximum from the maxHeap, instead of trying to traverse only one heap and reconfiguring the
    whole heap to find both maximum and minimum. As such, the algorithm entails inserting
    objects, say an Integer, into an array and arranging them so that they follow heap order,
    then performing respective functions, deleteMin or deleteMax, for respective heaps.
    When we delete the min from the minHeap, we recognize that index 1 is the min, then
    exchange positions with the last item, delete the min, then sink down the item that
    was swapped to maintain heap order. We must also delete the min value from the maxHeap
    to prevent duplicates since the two minHeap and maxHeap make up "one" PriorityQueue.
    The same strategy applies to deleting the max element from the maxHeap.
     */

    public class Item<Key extends Comparable<Key>> {
        Key key;
        int minIndex;
        int maxIndex;
    }
    public class MinMaxPriorityQueue<Key extends Comparable<Key>> {
        Item[] minHeap = new Item[10];
        Item[] maxHeap = new Item[10];
        int size = 0;

        public void insert(Key key) {
            Item pqItem = new Item();
            pqItem.key = key;

            minHeap[size] = pqItem;
            maxHeap[size] = pqItem;
            size++;
            swim(size);

        }

        public Key deleteMin() {
            Key min = minHeap[1].key;
            exch(1, size--, minHeap);
            sink(1);
            minHeap[size+1] = null;
            return min;

        }
        public Key deleteMax() {
            Key max = maxHeap[1].key;
            exch(1, size--, maxHeap);
            sink(1);
            maxHeap[size+1] = null;
            return max;
        }


        public Comparable findMax() {
            return maxHeap[1].key;
        }
        public Comparable findMin() {
            return minHeap[1].key;
        }

        public void resize(int size) {
            Item[] newMinHeap = new Item[size];
            Item[] newMaxHeap = new Item[size];

            System.arraycopy(minHeap, 1, newMinHeap, 1, size);
            System.arraycopy(maxHeap, 1, newMaxHeap, 1, size);

            // Setting original array reference to the resized array
            minHeap = newMinHeap;
            maxHeap = newMaxHeap;
        }

        // Helper functions for heap
        private void swim(int k) {
            // For min heap component
            while (k > 1 && greater(k/2, k)) {
                exch(k, k/2, minHeap);
                k = k/2;
            }

            // For max heap component
            while (k > 1 && less(k/2, k)) {
                exch(k, k/2, maxHeap);
                k = k/2;
            }
        }
        private void sink(int k) {
            // For min heap component
            while (2*k <= size) {
                int j = 2*k;
                if (j < size && greater(j, j+1)) j++;
                if (!greater(k, j)) break;
                exch(k, j, minHeap);
                k = j;
            }

            // For max heap component
            while (2*k <= size) {
                int j = 2*k;
                if (j < size && less(j, j+1)) j++;
                if (!less(k, j)) break;
                exch(k, j, maxHeap);
                k = j;
            }
        }



        // Helper functions for compare & exchange
        private boolean greater(int i, int j) {
            return minHeap[i].key.compareTo(minHeap[j].key) > 0;
        }
        private boolean less(int i, int j) {
            return maxHeap[i].key.compareTo(maxHeap[j].key) < 0;
        }
        private void exch(int i, int j, Item[] heap) {
            Comparable<Key> temp = heap[i].key;
            heap[i].key = heap[j].key;
            heap[j].key = temp;

        }

        public void main(String[] args) {
            MinMaxPriorityQueue<Integer> minMaxPriorityQueue = new MinMaxPriorityQueue<>();

            minMaxPriorityQueue.insert(10);
            minMaxPriorityQueue.insert(2);
            minMaxPriorityQueue.insert(40);
            minMaxPriorityQueue.insert(1);

            System.out.println("Delete Max: " + minMaxPriorityQueue.deleteMax() + " Expected: 40");
            System.out.println("Delete Min: " + minMaxPriorityQueue.deleteMin() + " Expected: 1");

            System.out.println("Find Max: " + minMaxPriorityQueue.findMax() + " Expected: 10");
            System.out.println("Find Min: " + minMaxPriorityQueue.findMin() + " Expected: 2");

            minMaxPriorityQueue.insert(99);
            minMaxPriorityQueue.insert(-1);

            System.out.println("Find Max: " + minMaxPriorityQueue.findMax() + " Expected: 99");
            System.out.println("Find Min: " + minMaxPriorityQueue.findMin() + " Expected: -1");
        }



    }



}
