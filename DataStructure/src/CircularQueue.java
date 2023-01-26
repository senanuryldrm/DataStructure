public class CircularQueue<T> {
    int tail, head;
    T[] items;

    public CircularQueue(Class<T> dataType, int size){
        this.tail=this.head=0;
        items=(T[])java.lang.reflect.Array.newInstance(dataType, size+1);
    }
    public void clear()
    {
        head = tail = 0;
    }
    public int size()
    {
        return items.length;
    }
    public boolean isEmpty()
    {
        return head == tail;

    }
    public int count()
    {
        return (head - tail) % size();
    }
    public boolean isFull()
    {
        return (tail + 1) % size() == head;
    }
    public void enQueue(T val) throws Exception {
        if (isFull())
            throw new Exception("Queue is full");
        else
        {
            tail = (tail + 1) % size();
            items[tail] = val;
        }

    }
    public T deQueue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is Empty");
        else
        {
            head = (head + 1) % size();
            return items[head];
        }

    }
    public void display()
    {
        if (isEmpty())
            System.out.println("Queue is Empty");
        else
        {
            int temp = head;
            while (temp != tail)
            {
                temp = (temp + 1) % size();
                System.out.println(items[temp]);
            }

        }
    }
}