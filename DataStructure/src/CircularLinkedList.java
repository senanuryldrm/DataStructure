public class CircularLinkedList <T extends Comparable> {
    Node<T> head;


    public Node<T> createNode(T val) {
        return new Node<T>(val);
    }


    public void addToFront(T val) {
        if (head == null) {
            head = createNode(val);
            head.next = head;
        } else {
            Node<T> iterator = head;
            while (iterator.next != head) {
                iterator = iterator.next;
            }
            Node<T> newNode = createNode(val);
            iterator.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void addToEnd(T val) {
        if (head == null) {
            head = createNode(val);
            head.next = head;
        } else {
            Node<T> iterator = head;
            while (iterator.next != head) {
                iterator = iterator.next;
            }
            Node<T> newNode = createNode(val);
            iterator.next = newNode;
            newNode.next = head;
        }
    }

}