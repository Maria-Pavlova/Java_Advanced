package Workshop_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;

    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            Node newNode = new Node(element);
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public int get(int index) {
        int element = 0;
        checkIndex(index);
        if (index <= this.size / 2) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            element = currentNode.currentValue;
        } else {
            Node currentNode = this.tail;
            for (int i = this.size-1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            element = currentNode.currentValue;
        }
        return element;
    }

    public int removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("Error while remove element");
        }else if (this.size == 1){
            int element = this.head.currentValue;
            this.head = this.tail = null;
            this.size--;
            return this.head.currentValue;
        }else {
            this.size--;
            int element = this.head.currentValue;
            this.head = this.head.next;
            this.head.prev = null;
           return element;
        }
    }
    public int removeLast(){
        if (isEmpty()){
            throw new IllegalStateException("Error while remove element");
        }else if (this.size == 1){
            int element = this.head.currentValue;
            this.head = this.tail = null;
            this.size--;
            return element;
        }else {
            int element = this.tail.currentValue;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
            return element;
        }
    }
    public void forEach(Consumer<Integer> consumer){
        Node currentNod = this.tail;
        while (currentNod != null){
            consumer.accept(currentNod.currentValue);
            currentNod = currentNod.next;
        }
    }
    public int[] toArray(){
        List<Integer> resultList = new ArrayList<>();
        forEach(el -> resultList.add(el));
        return resultList.stream().mapToInt(e->e).toArray();
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bound");
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
