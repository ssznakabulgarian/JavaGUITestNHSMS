public class CycleLinkedList<T> {
    private CycleLinkedListNode<T> first;
    private CycleLinkedListNode<T> last;
    private int size;

    public CycleLinkedList() {
        size = 0;
    }

    public boolean isEmpty(){return size == 0;}
    public int size(){return size;}
    public void add(T element){
        CycleLinkedListNode<T> newNode = new CycleLinkedListNode<>(element);
        if(isEmpty()){
            last = first = newNode;
        }else{
            last.setNext(newNode);
            last=newNode;
        }
        last.setNext(first);
        size++;
    }

    public void add(int index, T element){
        if(index > size || index<0) throw new IndexOutOfBoundsException();
        if(index == size) add(element);
        if(index == 0) addFront(element);
        CycleLinkedListNode<T> newNode = new CycleLinkedListNode<>(element);
        CycleLinkedListNode<T> previousNode = null;
        CycleLinkedListNode<T> currentNode = first;
        while (index>0){
            previousNode=currentNode;
            currentNode=currentNode.getNext();
            index--;
        }

        previousNode.setNext(newNode);
        newNode.setNext(currentNode);
        size++;
    }

    private void addFront(T element) {
        CycleLinkedListNode<T> newNode = new CycleLinkedListNode<>(element);
        if(isEmpty()){
            last = first = newNode;
        }else{
            newNode.setNext(first);
            first=newNode;
        }
        last.setNext(first);
        size++;
    }

    public T get(int index){
        index %= size;
        if(index < 0) index += size;
        CycleLinkedListNode<T> currentNode = first;
        while (index>0){
            currentNode=currentNode.getNext();
            index--;
        }
        return currentNode.getData();
    }

    public void clear(){
        size = 0;
        first = last = null;
    }
}
