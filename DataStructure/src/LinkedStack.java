public class LinkedStack <T extends Comparable>{
    Node <T> top;

    public boolean isEmpty(){
        return this.top==null;
    }

    public void push(T val){
        Node<T> newNode=new Node<T>(val);
        if(top==null)
            top=newNode;
        else{
            newNode.next=top;
            top=newNode;
        }
    }

    public T pop(){
        if(isEmpty())
            return null;
        else{
            T popped=top.value;
            top=top.next;
            return popped;
        }
    }



}
