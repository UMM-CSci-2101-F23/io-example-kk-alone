package umm2101;

// Binary Search Tree implementation
class BST<E extends Comparable<E>> {
    private BSTNode<E> root; // Root of the BST
    private int nodeCount; // Number of nodes in the BST

    // constructor
    BST() {
        root = null;
        nodeCount = 0;
    }

    // Reinitialize tree
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // e: The record to insert.
    public void insert(E e) {
        root = insertHelp(root, e);
        nodeCount++;
    }

    public BSTNode<E> getRoot() {
        return root;
    }

    private BSTNode<E> insertHelp(BSTNode<E> rt, E e) {
        if (rt==null) {
            return new BSTNode<>(e);
        }
        if (rt.getKey().compareTo(e) >= 0) {
            rt.setLeft(insertHelp(rt.getLeft(), e));
        } else {
            rt.setRight(insertHelp(rt.getRight(), e));
        }
        return rt;
    }

    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public E remove(E key) {
        E temp = findHelp(root, key); // First find it
        if (temp != null) {
            root = removeHelp(root, key); // Now remove it
            nodeCount--;
        }
        return temp;
    }

    // Return the record with key value k, null if none exists
    // key: The key value to find
    public E find(E key) {
        return findHelp(root, key);
    }

    // Return the number of records in the dictionary
    public int size() {
        return nodeCount;
    }

    private E findHelp (BSTNode<E> rt, E key){
        if (rt==null) {return null;}
        if (rt.getKey().compareTo(key) > 0) {
            return findHelp(rt.getLeft(), key);
        } else if (rt.getKey().compareTo(key) == 0) {
            return rt.getKey();
        } else {
            return findHelp(rt.getRight(), key);
        }
    }

    private BSTNode<E> removeHelp(BSTNode<E> rt, E key) {
        if (rt==null) return null;
        if (rt.getKey().compareTo(key) > 0) {
            rt.setLeft(removeHelp(rt.getLeft(), key));
        } else if (rt.getKey().compareTo(key) < 0) {
            rt.setRight(removeHelp(rt.getRight(), key));
        } else {//found it
            if (rt.getLeft() == null) return rt.getRight();
            else if (rt.getRight() == null) return rt.getLeft();
            else {//two children, need to do more work
                BSTNode<E> temp = getMax(rt.getLeft()); //grab the max value from the left tree
                rt.setKey(temp.getKey());
                rt.setLeft(deleteMax(rt.getLeft()));
            }
        }
        return rt;
    }

    private BSTNode<E> deleteMax(BSTNode<E> rt) {
        if (rt.getRight() == null) return rt.getLeft();
        rt.setRight(deleteMax(rt.getRight()));
        return rt;
    }

    // Get the maximum valued element in a subtree
    private BSTNode<E> getMax(BSTNode<E> rt) {
        if (rt.getRight() == null) return rt;
        return getMax(rt.getRight());
    }

    public String toString() {
        if (root != null) {
            // note that the toString() method of BST leverages 
            // the toString() of BSTNode (root is a BSTNode)
            return root.toString();
        } else {
            return "";
        }
    }

}
