// Name: Randy Truong
// CS 171

package Assignment5;

public class PQExplicit<Key extends Comparable<Key>> {
    private Item root;
    private Item recent;
    
    public class Item {
        int size; // item size
        Key key; // item key
        // Left child, right child, and parent child in a heap:
        Item left;
        Item right;
        Item parent;

        // Constructor
        public Item(Key key, int size) {
            this.key = key;
            this.size = size;
        }
    }

    // Private methods for each link
    // Method for returning size of structure
    private int size(Item x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    // Helper functions for heap
    private void swim(Item x) {
        if (x == null) {
            return;
        }
        if (x.parent == null) {
            return;
        }
        // If the key comparison, then swap the two items, and swim to root
        if (x.key.compareTo(x.parent.key) > 0) {
            exch(x, x.parent);
            swim(x.parent);
        }
    }
    // Method for moving items down heap
    private void sink(Item x) {
        Item swapItem;
        
        if (x == null) {
            return;
        }
        if (x.left == null && x.right == null) {
            return;
        } else if (x.left == null) {
            swapItem = x.right;
            if (x.key.compareTo(swapItem.key) < 0) {
                exch(swapItem, x);
            }
        } else if (x.right == null) {
            swapItem = x.left;
            if (x.key.compareTo(swapItem.key) < 0)
                exch(swapItem, x);
        } else {
            if (x.left.key.compareTo(x.right.key) >= 0) {
                swapItem = x.left;
            }
            else {
                swapItem = x.right;
            }
            if (x.key.compareTo(swapItem.key) < 0) {
                exch(swapItem, x);
                sink(swapItem);
            }
        }
    }

    // Method for swapping between two items
    private void exch(Item x, Item y) {
        Key temp = x.key;
        x.key = y.key;
        y.key = temp;
    }

    // Insert item into each link
    private Item insert(Item x, Key key) {
        if (x == null) {
            recent = new Item(key, 1);
            return recent;
        }

        // Determines the size of the left side and the right side in heap using private method
        int leftSize = size(x.left);
        int rightSize = size(x.right);

        if (leftSize <= rightSize) {
            // Inserts item to the left
            Item inserted = insert(x.left, key);
            x.left = inserted;
            inserted.parent = x;
        }
        else {
            // Inserts item to the right
            Item inserted = insert(x.right, key);
            x.right = inserted;
            inserted.parent = x;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // Maintain heap order
    private Item resetRecent(Item x) {
        if (x == null) {
            return null;
        }
        // Parent item
        if (x.left == null && x.right == null) {
            return x;
        }
        // Left child
        if (size(x.right) < size(x.left)) {
            return resetRecent(x.left);
        }
        // Right child
        else {
            return resetRecent(x.right);
        }

    }

    public void insert(Key key) {
        root = insert(root, key);
        swim(recent);
    }

    // Determines max of PQ
    public Key findMax() {
        if (root == null) {
            return null;
        }
        return root.key;
    }

    // Deletes max of PQ
    public Key deleteMax() {
        // If PQ size is 1, return that key and declare empty queue
        if (size() == 1) {
            Key temp = root.key;
            root = null;
            return temp;
        }
        // Swap root key with the last inserted item
        exch(root, recent);
        // Record the parent node of the last inserted item
        Item recParent = recent.parent;
        Key recKey = recent.key;

        // No left child
        if (recent == recParent.left) {
            recParent.left = null;
        }
        // No right child
        else {
            recParent.right = null;
        }
        // Traverses the tree
        Item traverse = recent;
        while (traverse != null) {
            traverse.size--;
            traverse = traverse.parent;
        }
        recent = resetRecent(root);
        sink(root);
        return recKey;

    }
    // Returns size of structure
    public int size() {
        return size(root);
    }

    public static void main(String[] args) {
        PQExplicit<Integer> PQExplicit = new PQExplicit();

        System.out.println("Size: " + PQExplicit.size() + " Expected: 0");

        PQExplicit.insert(10);
        PQExplicit.insert(2);
        PQExplicit.insert(7);
        PQExplicit.insert(20);

        PQExplicit.insert(18);
        PQExplicit.insert(13);
        PQExplicit.insert(15);
        PQExplicit.insert(2);

        System.out.println("Size: " + PQExplicit.size() + " Expected: 8");

        int size = PQExplicit.size();
        for(int i = 0; i < size; i++) {
            System.out.println("Item removed: " + PQExplicit.deleteMax());
        }
    }

}
