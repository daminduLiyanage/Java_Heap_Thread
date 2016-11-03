import java.util.List;

/**
 * Created by Damindu on 11/2/2016.
 */
public class HeapThread extends Thread{
    List<Integer> list;
    Heapsort heapsort;

    /**
     * Thread 1 & 2. Sorts the divided lists.
     * @param list
     * @param heapsort
     */
    public HeapThread(List<Integer> list, Heapsort heapsort){
        this.list = list;
        this.heapsort = heapsort;
    }

    public void run(){
        this.heapsort.sort();
    }
}
