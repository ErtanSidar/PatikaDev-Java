package Homework.ListExample;

public class MyList<T> {

    private T[] array;

    //set default size of array to 10
    public MyList() {
        this.array = (T[]) new Object[10];
    }

    public MyList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public int size() {

        int size = 0;
        for (T i : array) {
            if (i != null) {
                size++;
            }
        }
        return size;
    }

    public int getCapacity() {
        return this.array.length;
    }

    public void add(T element) {
        //add to element in array
        if (this.size() == this.getCapacity()) {

            T[] newArray = (T[]) new Object[this.getCapacity() * 2];
            for (int i = 0; i < this.array.length; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        this.array[this.size()] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        return this.array[index];
    }

    public T remove(int index) {

        if (index < 0 || index >= this.size()) {
            return null;
        }

        //removed element
        T removedElement = this.array[index];
        //move all elements after removed element to left
        for (int i = index; i < this.size() - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.size() - 1] = null;
        return removedElement;
    }

    public T set(int index, T data) {

        if (index < 0 || index >= this.size()) {
            return null;
        }
        T oldData = this.array[index];
        this.array[index] = data;
        return oldData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T i : array) {
            if (i != null) {
                sb.append(i.toString() + " ");
            }
        }
        return sb.toString();
    }

    //find index of element
    public int indexOf(T element) {

        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //find last element of array
    public int lastIndexOf(T element) {

        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public T[] toArray() {
        T[] newArray = (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.array[i] = null;
        }
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public MyList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= this.size() || toIndex < 0 || toIndex >= this.size() || fromIndex > toIndex) {
            return null;
        }
        MyList<T> newList = new MyList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            newList.add(this.array[i]);
        }
        return newList;
    }
}