import java.util.List;

/**
 * Created by Damindu on 11/2/2016.
 */
public class HeapMerger extends Thread{
    List<Integer> listA;
    List<Integer> listB;
    List<Integer> list;
    Base base;
    Heapsort heapsort;

    public HeapMerger(List<Integer> listA, List<Integer> listB, List<Integer> list, Base base){
        this.list = list;
        this.listA = listA;
        this.listB = listB;
        this.base = base;
        heapsort = new Heapsort(list);
        this.start();
    }

    /**
     * Thread to Merge Threads
     */
    public void run(){
        base.mergeList(this.listA, this.listB, this.list);
        this.heapsort.heapSort();
        System.out.println(list);
    }
}
