package DataStructures;

public class MyQueue<T> {

    private class MyQueueNode<T> {
        private T data;
        private MyQueueNode<T> next;

        public MyQueueNode(T data) {
            this.data = data;
        }
    }

    private MyQueueNode<T> firstNode;
    private MyQueueNode<T> lastNode;

    public void add(T data){
        MyQueueNode<T> newNode=new MyQueueNode<T>(data);
        if(firstNode==null && lastNode==null){
            firstNode=newNode;
            lastNode=newNode;
        }
        else {
            lastNode.next=newNode;
            newNode=lastNode;
        }
    }

    public T remove(){
       // MyQueueNode<T> newNode=new MyQueueNode<T>(data);
        if(firstNode==null && lastNode==null){
           throw new IllegalArgumentException();
        }
        MyQueueNode<T> toRemove=firstNode;
        firstNode=firstNode.next;
        return toRemove.data;
    }
}
