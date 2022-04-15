public class CycleLinkedListNode<T> {
    private CycleLinkedListNode<T> next;
    private T data;

    public CycleLinkedListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CycleLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(CycleLinkedListNode<T> next) {
        this.next = next;
    }
}
