import java.util.List;

/**
 * Created by Damindu on 11/1/2016.
 */
public class Heapsort {

    List<Integer> list;

    public Heapsort(List<Integer> list){
        this.list = list;
        //heapSort(this.list);
    }

    public synchronized void maxHeapify(List<Integer> list, int curIndex, int heapSize){
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

    public synchronized void buildMaxHeap(List<Integer> list, int heapSize){
        // call maxHeapify on all internal nodes
        int lastElementIndex = list.size() - 1;
        int parentIndex = (lastElementIndex - 1)/2;
        for(int i = parentIndex; i >= 0; i--){
            maxHeapify(list, i, heapSize);
        }
    }

    public synchronized void heapSort(){//List<Integer> list){
        List<Integer> list = this.list;
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


    /**
     * Swaps i & j list items. (counted from 0)
     * @param list
     * @param i
     * @param j
     */
    public synchronized void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.add(i, list.get(j));
        list.remove(i + 1);
        list.remove(j);
        list.add(j, temp);
    }
}