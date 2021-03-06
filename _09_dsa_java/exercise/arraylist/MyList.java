package _09_dsa_java.exercise.arraylist;

import java.util.Arrays;
import java.util.IllformedLocaleException;

public class MyList<E> {
    private int size = 0; // so luong phan tu co trong myarrlist
    static final int DEFAULT_CAPACITY = 10; // suc chua
    private Object[] elements; // mang chua cac phan tu

// pthuc constructor ko tham so voi suc chua mac dinh la 10

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // pthuc contructor voi suc chua duoc truyen vao
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }

    }

    //pthuc tra ve so luong co trong arrlist
    private int size() {
        return this.size;
    }

    //pthuc clear xoa het phan tu trong arrlist
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    //pthuc them 1 phan tu vao mylist
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(1);
        }
        elements[size] = element;
        size++;
        return true;
    }
    // pthuc tang kich thuoc cua mylist
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }

    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    @Override
    public String toString() {
       String str = "";
        for (int i = 0; i <this.size-1 ; i++) {
            str+= elements[i] + ", ";
        }
        str+=elements[this.size-1];
        return "["+ str +"]";
    }


    // pthuc l???y gi?? tr??? c???a ph???n t??? n???m trong arrlist
    public E get (int index){
        return (E) elements[index];
    }

//    pthuc l???y ???????c v??? tr?? c???a 1 ph???n t??? trong arrlist
    public int indexOf(E element){
        int index = -1;
        for (int i = 0; i <size ; i++) {
            if (this.elements[i].equals(element)){
                return i;
            }
        }
        return index;
    }

//    pthuc t??m xem c?? ph???n t??? trong arrlist kh??ng n???u c?? th?? true
    public boolean contains(E elenment){
        return this.indexOf(elenment)>=0;
    }


//    pthuc x??a 1 phan t??? t???i 1 v??? tr?? index
    public  E remove(int index){
        if (index<0 || index> elements.length){
            throw new IllegalArgumentException("Error index: "+index);
        }
        E element = (E) elements[index];
        for (int i = index; i <size-1 ; i++) {
            elements[i] = elements[i+1];
// d??ng for ch???y t??? index t???i size -1...d???n ph???n t???  b??n ph???i v??? 1 ????n v??? ????? gi?? tr??? t???i index b??? ghi ????
        }
        elements[size -1] = null;
        size--;
        return  element;
    }
}
