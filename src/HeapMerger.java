/**
 * Created by Damindu on 11/2/2016.
 */
public class HeapMerger extends Thread{
    HeapThread threadA;
    HeapThread threadB;
    int[] array;

    public HeapMerger(int[] array, HeapThread threadA, HeapThread threadB){
        this.threadA = threadA;
        this.threadB = threadB;
        this.array = array;

    }

    /**
     * Thread to Merge Threads
     */
    public void run(){}

}
