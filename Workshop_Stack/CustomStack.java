package Workshop_Stack;

public class CustomStack {

    public static final int INITIAL_CAPACITY = 4;
    private static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
        this.data = new int[INITIAL_CAPACITY];
    }

    public void push(int element) {
        ensureCapacity();
        this.data[size] = element;
        this.size++;

    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            this.resize();
        }
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        int temp[] = new int[capacity];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    public int pop() {
        this.size--;
        int itemToRemove = this.data[size];
        this.data[size] = 0;
        return itemToRemove;
    }

    public int peek() {
        return this.data[size - 1];
    }

}
