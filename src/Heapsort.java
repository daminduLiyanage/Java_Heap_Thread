import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Damindu on 11/1/2016.
 */
public class Heapsort {
//    ArrayList<Integer> list = new ArrayList();
//    public Heapsort(ArrayList<Integer> list){
//        this.list = list;
//        heapSort(this.list);
//    }

    public static void maxHeapify(ArrayList<Integer> list, int curIndex, int heapSize){
        // Left child in heap
        int left = 2*curIndex+1;
        // Right child in heap
        int right = 2*curIndex+2;
        int largest = curIndex;

        if( left < heapSize && list.get(left) > list.get(curIndex) ) {
            largest = left;
        }

        if( right < heapSize && list.get(right) > list.get(largest) ) {
            largest = right;
        }

        if( largest != curIndex ){
            swap(list, curIndex, largest);
            maxHeapify(list, largest, heapSize);
        }
    }

    public static void buildMaxHeap(ArrayList<Integer> list, int heapSize){
        // call maxHeapify on all internal nodes
        int lastElementIndex = list.size() - 1;
        int parentIndex = (lastElementIndex - 1)/2;
        for(int i = parentIndex; i >= 0; i--){
            maxHeapify(list, i, heapSize);
        }
    }

    public static void heapSort(ArrayList<Integer> list){
        if(list == null || list.size() < 2)
            return;

        buildMaxHeap(list, list.size());
        int heapSize = list.size();
        for(int i = list.size() - 1; i > 0; i--){
            swap(list, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(list, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(12);
        list.add(35);
        list.add(87);
        list.add(26);
        list.add(9);
        list.add(28);
        list.add(7);
        //int[] list = {12, 35, 87, 26, 9, 28, 7};
        System.out.println("Original List:\t\t" + list);
        heapSort(list);
        System.out.println("Sorted List:\t\t" + list);
    }

    /**
     * Swaps i & j list items. (counted from 0)
     * @param list
     * @param i
     * @param j
     */
    public static void swap(ArrayList<Integer> list, int i, int j){

        int temp = list.get(i);
        list.add(i, list.get(j));
        list.remove(i+1);
        list.remove(j);
        list.add(j, temp);
    }

 //   private void swap(ArrayList<Integer> list, int i, int j) {
//        int tmp = list[i];
//        list[i] = list[j];
//        list[j] = tmp;
//        int temp = list.get(i);
//        list.remove(i);
//
//
//    }
}