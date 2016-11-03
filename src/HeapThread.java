import java.util.List;

/**
 * Created by Damindu on 11/2/2016.
 */
public class HeapThread extends Thread{

    List<Integer> list;
    Heapsort heapsort;

    public HeapThread(List<Integer> list, Heapsort heapsort){
        this.list = list;
        this.heapsort = heapsort;
    }

    public void run(){
        //this.heapsort = new Heapsort(this.list);//sorting
        this.heapsort.heapSort();
        System.out.println(list);
    }
}
