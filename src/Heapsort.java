import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Damindu on 11/1/2016.
 */
public class Heapsort {
    ArrayList<Integer> array = new ArrayList();
    public Heapsort(int[] array){
        this.array = array;
        heapSort(this.array);
    }

    public void maxHeapify(int[] array, int curIndex, int heapSize){
        // Left child in heap
        int left = 2*curIndex+1;
        // Right child in heap
        int right = 2*curIndex+2;
        int largest = curIndex;

        if(left < heapSize && array[left] > array[curIndex]) {
            largest = left;
        }

        if(right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if(largest != curIndex){
            swap(array, curIndex, largest);
            maxHeapify(array, largest, heapSize);
        }
    }

    public void buildMaxHeap(int[] array, int heapSize){
        // call maxHeapify on all internal nodes
        int lastElementIndex = array.length - 1;
        int parentIndex = (lastElementIndex - 1)/2;
        for(int i = parentIndex; i >= 0; i--){
            maxHeapify(array, i, heapSize);
        }
    }

    public void heapSort(int[] array){
        if(array == null || array.length < 2)
            return;

        buildMaxHeap(array, array.length);
        int heapSize = array.length;
        for(int i = array.length - 1; i > 0; i--){
            swap(array, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(array, 0, heapSize);
        }
    }
//
//    public static void main(String[] args) {
//        int[] array = {12, 35, 87, 26, 9, 28, 7};
//        System.out.println("Original Array:\t\t" + Arrays.toString(array));
//        heapSort(array);
//        System.out.println("Sorted Array:\t\t" + Arrays.toString(array));
//    }

    private void swap(ArrayList<Integer> array, int i, int j) {
//        int tmp = array[i];
//        array[i] = array[j];
//        array[j] = tmp;
        int temp = array.get(i);
        array.remove(i);


    }
}