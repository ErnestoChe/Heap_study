package com.company;

public class Heap {

    public int [] HeapArray; // хранит неотрицательные числа-ключи
    public int size;
    public Heap() { HeapArray = null; }

    public void MakeHeap(int[] a, int depth)
    {
        size = a.length;
        int length = (int)Math.pow(2, depth+1) - 1;
        HeapArray = new int[length];
        for (int i = 0; i < Math.min(a.length, length); i++) {
            HeapArray[i] = a[i];
        }

        int startIdx = (length / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapify(HeapArray, length, i);
        }
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        // ...
    }

    /**
     *
     * @param arr массив из которого делаем кучу
     * @param n размер кучи
     * @param i корневой элемент поддерева
     */
     void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            swap(i, largest);

            heapify(arr, n, largest);
        }
    }

    public void swap(int i, int j)
    {
        int tmp = HeapArray[i];
        HeapArray[i] = HeapArray[j];
        HeapArray[j] = tmp;
    }

    public int GetMax()
    {
        // вернуть значение корня и перестроить кучу
        if(size == 0){
            return -1;
        }
        int pop = HeapArray[0];
        HeapArray[0] = HeapArray[--size];
        HeapArray[size] = 0;
        heapify(HeapArray, size, 0);
        return pop; // если куча пуста
    }

    void sendUp(int index){
         int parent;
         if(index!=0){
             parent = (index - 1)/2;
             if(HeapArray[parent]<HeapArray[index]){
                 swap(parent, index);
                 sendUp(parent);
             }
         }
    }

    public boolean Add(int key)
    {
        // добавляем новый элемент key в кучу и перестраиваем её
        if(size == HeapArray.length){
            return false;
        }else{
            size++;
            HeapArray[size-1] = key;
            sendUp(size-1);
            return true;
        }
         // если куча вся заполнена
    }
}