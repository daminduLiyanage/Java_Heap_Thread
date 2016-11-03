import java.util.List;

/**
 * Created by Damindu on 11/2/2016.
 */
public class HeapMerger extends Thread{
    HeapThread threadA;
    HeapThread threadB;
    List<Integer> list;

    public HeapMerger(List<Integer> list, HeapThread threadA, HeapThread threadB){
        this.threadA = threadA;
        this.threadB = threadB;
    }

    /**
     * Thread to Merge Threads
     */
    public void run(){}

}
