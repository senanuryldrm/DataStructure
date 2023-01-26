public class LinkedList<T extends Comparable> {
    private Node<T> head;

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }

    public void sortedAdd(T val){
        Node<T> newNode= createNode(val);
        Node<T> iterator= head;
        if(head==null)
            System.out.println("list is empty");
        else {
            while(iterator!=null){

            }
        }

    }

    public int countElement() {
        Node<T> iterator = head;
        int count = 0;
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    public void sort() {
        Node<T> current = head, index;
        T iterator;

        if (head == null) {
            System.out.println("list is empty...");
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.value.compareTo(index.value) == -1) {
                        iterator = current.value;
                        current.value = index.value;
                        index.value = iterator;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }


    public void addFront(T val){
        Node<T> newNode=createNode(val);
        newNode.next=head;
        head=newNode;
    }
    public void addRightAfterHead(T val){
        if(head==null){
            //addFront(val);
            head=createNode(val);
        }
        else{
            Node<T> newNode=createNode(val);//new Node(val);
            newNode.next=head.next;
            head.next=newNode;
        }
    }
    public boolean search(T val){
        if (head==null )
            return false;
        Node<T> iterator=head;
        while(iterator!=null){
            if (iterator.value.compareTo(val)==0)
                return true;
            iterator=iterator.next;
        }
        return false;
    }
    public boolean searchRecursive(T val, Node<T> tempHead){
        if( tempHead==null)
            return false;
        if(tempHead.value.compareTo(val)==0)
            return true;
        else{
            return searchRecursive(val, tempHead.next);
        }
    }
    public boolean searchRecursive(T val){
        return searchRecursive(val, head);
    }

    public void delete(T val){
        if(search(val)==false) {
            System.out.println("the value does not exist");
            return;
        }
        if(head.value.compareTo(val)==0){
            head=head.next;
        }
        Node<T> iterator=head,prev=head;
        while(iterator.value.compareTo(val)!=0){
            prev=iterator;
            iterator=iterator.next;
        }
        prev.next=iterator.next;
    }


    public T findMax(){
        if(head==null)
            return null;
        Node<T> iterator=head;
        T max = head.value;
        while(iterator!=null){
            if(iterator.value.compareTo(max)==1)
                max=iterator.value;
            iterator=iterator.next;
        }
        return max;
    }




    public void addToEnd(T val){
        if (head==null)
            addFront(val);
        else{
            Node<T> iterator=head;
            while(iterator.next!=null)
                iterator=iterator.next;
            iterator.next=createNode(val);

        }
    }



    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.println(iterator);
            iterator=iterator.next;

        }
    }

}