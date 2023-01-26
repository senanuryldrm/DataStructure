public class TNode <T extends Comparable> {
    public T value;
    TNode<T> left, right;

    public TNode(T val) {
        this.value = val;
        this.left = this.right = null;
    }

    public String toString() {

        return this.value.toString();
    }
}