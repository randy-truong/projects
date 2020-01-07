// Name: Randy Truong
// CS 171

package Assignment6;


public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    // Data fields
    private Node root;

    private class Node {
        // Data fields
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        // Node constructor
        public Node(Key key, Value value, int size) {
            this.key = key;
            this.val = value;
            this.size = size;
        }
    }

    // Method for returning size (key pairs) of a node
    private int size(Node x) {
        // If the node is null, then it is empty or does not exist, so size = 0
        if (x == null) {
            return 0;
        }
        // Returns size of the given node
        else {
            return x.size;
        }
    }

    // Method for returning the height of tree
    private int height(Node x) {
        // If the node is null, then it is empty or does not exist
        // so it does not have a height
        if (x == null) {
            return -1;
        }
        // The height of the tree is determined by the longest length/path
        // so we find the max length between the left subtree and the right subtree
        // in order to computer the height of the tree.
        return 1 + Math.max(height(x.left), height(x.right));
    }

    // Recursive method for traversing BST from Node x (in this case, we
    // will be using root as our initial node)
    private Node min(Node x) {
        // Traverses the left subtree until we reach a node
        // with no children nodes.
        if (x.left == null) {
            return x;
        }
        else {
            return min(x.left);
        }
    }

    // Recursive method for deleting the smallest key-value pair
    private Node deleteMin(Node x) {
        // If the parent node has no left child, then return the right child
        if (x.left == null) {
            return x.right;
        }
        // Recursively traverse the tree until the previous if conditional is true
        // The smallest left key is set equal to the right key.
        x.left = deleteMin(x.left);

        // Computes and updates the size of the root
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // Recursive method for deleting a specific key-value pair
    private Node delete(Node x, Key key) {
        // If the input node is null, then return null because nothing exists
        if (x == null) {
            return null;
        }

        // Comparison conditionals to determine where to delete the key-value pair (left subtree or right subtree)
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        }
        else if (cmp > 0) {
            x.right = delete(x.right, key);
        }
        else {
            // If there is no right child, return left child
            if (x.right == null) {
                return x.left;
            }
            // If there is no left child, return right child
            if (x.left == null) {
                return x.right;
            }
            // Swapping
            Node temp = x; // assigned root node
            x = min(temp.right); // root node becomes the smallest key-value pair in the temp BST right subtree
            x.right = deleteMin(temp.right); // right child of smallest key-value pair assigned deleted
            // smallest key-value pair in right subtree of root node
            x.left = temp.left; // left child of x assigned left child of the temporary root node
        }
        // Computes and updates the size of the root
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // Inserts the given key-value pair into the root node, and updates
    // the BST tree accordingly
    private Node put(Node x, Key key, Value val) { // Method showed in lecture

        // If the given node is empty, create a new node (or our BST)
        // with the given key-value pair
        if (x == null) {
            return new Node(key, val, 1);
        }
        // Comparison conditionals to determine where to insert the key-value pair (left subtree or right subtree)
        int cmp = key.compareTo(x.key);
        // If less than 0, insert key-value pair into left subtree
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        }
        // If greater than 0, insert key-value pair into right subtree
        else if (cmp > 0) {
            x.right = put(x.right, key, val);
        }
        // Otherwise, the value of the key is updated with given value
        else {
            x.val = val;
        }
        // Computes and updates the size of the root
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    // Recursive method for in-order traversal of binary search tree
    private void printbstinorder(Node x) {
        // Conditional used for traversing subtree until a parent node has no left or right subtrees
        if (x == null) {
            return;
        }
        printbstinorder(x.left); // first traverse the left subtree until null
        System.out.print(x.key+ " "); // print the key at leftmost node
        printbstinorder(x.right); // now traverse the right subtree
    }

    // Wrapper-helper methods because the end user
    // is not calling a specific argument, rather we are
    // calling methods using the root as the argument
    // as we construct the tree from the root.
    public int size() {
        return size(root);
    }

    // Wrapper for height method, returns height of the root (entire tree)
    public int height() {
        return height(root);
    }

    // Wrapper for delete method, accepts a key from end user
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("A null key was entered.");
        }
        root = delete(root, key);
    }

    // Wrapper for put method, accepts a key and a value from end user
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("A null key was entered.");
        }
        if (val == null) {
            delete(key);
            return;
        }
        // Updates root node with the new key-value pair
        root = put(root, key, val);
    }

    // Wrapper for printing out the in-order traversal of BST
    public void printbstinorder() {
        printbstinorder(root);
        System.out.println("");
    }

    // Main method for testing
    public static void main(String[] args) {
        BinarySearchTree<Character, Integer> binarySearchTree = new BinarySearchTree<>();
        String test = "EASYQUESTION";
        System.out.println("Height: " + binarySearchTree.height() + " Size: " + binarySearchTree.size());
        for(int i = 0 ; i < test.length(); i++){ binarySearchTree.put(test.charAt(i),test.charAt(i) + 0); System.out.println("After put: " +test.charAt(i) + " value: " +(test.charAt(i) +
                0) +" Height: " + binarySearchTree.height() + " Size: " + binarySearchTree.size()); }
        binarySearchTree.printbstinorder();
        binarySearchTree.delete('S');
        System.out.println("Delete S, Height: " + binarySearchTree.height() + " Size: " + binarySearchTree.size());
        binarySearchTree.printbstinorder();
        binarySearchTree.delete('O');
        System.out.println("Delete O, Height: " + binarySearchTree.height() + " Size: " + binarySearchTree.size());
        binarySearchTree.printbstinorder();

    }



}
