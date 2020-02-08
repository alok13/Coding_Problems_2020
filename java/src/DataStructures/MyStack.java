package DataStructures;

public class MyStack<T> {

    private class StackNode<T> {
        private T value;
        private StackNode next;

        public StackNode(T data) {
            this.value = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new IllegalArgumentException();
        }
        T item = top.value;
        top = top.next;
        return item;
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<T>(data);
        newNode.next = top;
        top = newNode;
    }
}
