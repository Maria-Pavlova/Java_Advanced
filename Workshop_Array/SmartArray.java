package Workshop_Array;

import java.util.function.Consumer;

public class SmartArray {
    public static final int INITIAL_CAPACITY = 4;
    private static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;
        this.data = new int[INITIAL_CAPACITY];
    }


    public void add(int element) {
        ensureCapacity();
        this.data[size] = element;
        this.size++;
    }

    public int size() {
        return this.size();
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        int temp[] = new int[capacity];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        if (index >= this.size || index < 0) {
            String message = String.format("Index %d is out of bound", index);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public int remove(int index) {
        int numToRemove = this.get(index);
        this.shift(index);
        this.size--;
        if (this.capacity / this.size > 4) {
            this.shrink();
        }
        return numToRemove;
    }

    private void shrink() {
        this.capacity = this.capacity / 2;
        int temp[] = new int[capacity];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    private void shift(int index) {
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.data[size - 1] = 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        this.checkIndex(index);
        this.ensureCapacity();
        this.size++;
        this.shiftRight(index);
        this.data[index] = element;
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index; i++) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            this.resize();
        }
    }
    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i <this.size ; i++) {
            consumer.accept(this.data[i]);
        }
    }

}