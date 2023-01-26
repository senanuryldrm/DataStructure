public class DoublyLinkedList <T extends Comparable> {
    DNode<T> head;

    public void addToFront(T val) {
        DNode<T> newNode = new DNode<>(val);
        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addToEnd(T val) {
        DNode<T> newNode = new DNode<>(val);
        DNode<T> iterator = head;
        if (head == null)
            head = newNode;
        else {
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.next.prev = newNode;
        }
    }

    public void sortList() {
        DNode<T> newNode = head, index = null;
        T iterator;

        if (head == null) {
            System.out.println("list is empty...");
        } else {
            while (newNode != null) {
                index = newNode.next;
                while (index != null) {
                    if (newNode.value.compareTo(index.value) == -1) {
                        iterator = newNode.value;
                        newNode.value = index.value;
                        index.value = iterator;
                    }
                    index = index.next;
                }
                newNode = newNode.next;
            }
        }
    }


    public DNode<T> getHead() {
        return head;
    }

    public void setHead(DNode<T> head) {
        this.head = head;
    }

    public int countElement() {
        DNode<T> iterator = head;
        int count = 0;
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }


    public void display() {
        DNode<T> newNode = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while(newNode != null) {

            System.out.print(newNode.value + " ");
            newNode = newNode.next;
        }
    }
}
