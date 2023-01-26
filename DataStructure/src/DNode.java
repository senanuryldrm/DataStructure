public class DNode <T extends Comparable> {
    public T value;
    public DNode<T> next;
    public DNode<T> prev;

    public DNode(T val) {
        this.value = val;
        this.next = this.prev = null;
    }

    public String toString() {

        return this.value.toString();
    }
}
