package umm2101;

public class BSTNode<KT extends Comparable<? super KT>> {
    private KT key;
    private BSTNode<KT> right;
    private BSTNode<KT> left;

    public BSTNode(KT key) {
        this.key = key;
    }

    public KT getKey() {
        return key;
    }

    public void setKey(KT key) {
        this.key = key;
    }

    public BSTNode<KT> getRight() {
        return right;
    }

    public BSTNode<KT> getLeft() {
        return left;
    }

    public void setRight(BSTNode<KT> right) {
        this.right = right;
    }

    public void setLeft(BSTNode<KT> left) {
        this.left = left;
    }

    // TODO #5 (for an S on outcome 2): Write a static method in BSTNode called `preOrder()` 
    // that uses a pre-order traversal to collect the values of the keys 
    // in the order a pre-order traversal would visit them. The method should return a String.

    // TODO #6 (for an E on outcome 2): Write a static method in BSTNode called `postOrder()`
    // that uses a post-order traversal to collect the values of the keys 
    // in the order a post-order traversal would visit them. The method should return a String.
    
    private String printHelp(BSTNode<KT> rt) {
        if (rt == null) return "";
        return printHelp(rt.getLeft()) + printVisit(rt.getKey()) + printHelp(rt.getRight());
    }

    private String printVisit(KT element) {
        return element.toString() + ", ";
    }

    public String toString() {
        return printHelp(this);
    }
}
