import java.util.Arrays;

public class List<T> {
    private T[] arr;
    private int capacity;
    private int size;

    public List(){
        this.capacity = 10;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];

    }
    public List(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }
    public int getSize() {
        return size;
    }
    public void add(T data){
        if (getSize() < this.capacity ){
            this.arr[this.size] = data;
            this.size++;
        }else{
            this.capacity *= 2;
            System.out.println("List capacity has increased due to not enough space");
        }
    }

    public T getIndex(int index){
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                return arr[i];
            }
        }
        return null;
    }

    public void remove(int index){
        for(int i = index; i < arr.length-1; i++){
            this.arr[i] = this.arr[i+1];
        }
        arr[arr.length-1] = null;
        size--;
    }
    public T set(int index, T data){
        if (index + 1 <= this.size){
            return this.arr[index] = data;
        }else {
            return null;
        }
    }
    public int indexOf(T data) {
        for (int i = 0; i < arr.length -1; i++ ){
            if (arr[i] == data){
                return i;
            }
        }
        return -1;
    }

   boolean isEmpty(){
        return this.size == 0;
   }

    public T[] toArray(){
        return Arrays.copyOf(arr, size);
    }

    public void clear(){
        arr = (T[]) new Object[10];
        size = 0;
    }
    boolean contains(T data){
        for (int i = 0; i <= this.size; i++){
            if (arr[i] == data){
                return true;
            }
        }
        return false;
    }

    public List<T> sublist(int start, int finish){
        List<T> subList = new List<>(finish-start+1);
        for(int i = start; i <=finish; i++){
            subList.add(this.getIndex(i));
        }
        return subList;

    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }



    public void setSize(int size) {
        this.size = size;
    }
}
