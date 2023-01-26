public class Queue <T extends Comparable> {

    private T [] items;
    private int head;
    private int tail;

    public Queue(Class<T> dataType, int size) {
        head = tail = -1;
        items = (T[])java.lang.reflect.Array.newInstance(dataType, size);
    }

    public int size() {
        return items.length;
    }

    public boolean isFull() {
        return tail == size()-1;
    }

    public boolean isEmpty() {
        //return head == 0;???
        //return tail == -1;???
        return head == tail;
    }

    public void enqueue(T val) {
        if(!isFull()) {
            tail++;
            items[tail] = val;
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            head++;
            return items[head];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return items[head+1];
        }
        return null;
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = head+1; i <= tail; i++) {
                System.out.println(items[i]);
            }
        }
    }

}

