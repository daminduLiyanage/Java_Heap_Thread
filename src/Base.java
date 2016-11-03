import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;


/**
 * Created by Damindu on 11/2/2016.
 */
public class Base {
    HeapThread threadA;
    HeapThread threadB;
    HeapMerger mergeThread;

    List<Integer> list;
    List<Integer> list1;
    List<Integer> list2;
    List<Integer> listA;
    List<Integer> listB;

    Heapsort sort1;
    Heapsort sort2;

    //Locks to avoid Java.Util List concurrent access exceptions. Implemented as a precaution.
    static Semaphore A = new Semaphore(1);
    static Semaphore B = new Semaphore(0);

    /**
     * Base class acts as the base for 3 threads
     * @param list
     */
    public Base(List<Integer> list){
        this.list = list;
        split(list, findMidIndex());

        //values assigned to 1 & 2 threads
        this.sort1 = new Heapsort(this.listA);
        this.threadA = new HeapThread(this.listA, this.sort1);
        this.sort2 = new Heapsort(this.listB);
        this.threadB = new HeapThread(this.listB, this.sort2);

        assist();

        try{
            this.threadA.join();
            this.threadB.join();
            //values assigned to thread 3
            this.mergeThread = new HeapMerger(this.listA, this.listB, this.list, this);
            this.mergeThread.join();
        } catch (InterruptedException e){
            System.out.println(e);
        }
        //output
        System.out.println("Thread 1 Output:"+listA);
        System.out.println("Thread 2 Output:"+listB);
        System.out.println("Thread 3 Output:"+list);
    }

    /**
     * To start the threads.
     */
    public void assist(){
        try {
            runA();
            runB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void runA() throws InterruptedException {
        A.acquire();
        threadA.start();
        B.release();
    }

    public void runB() throws InterruptedException{
        B.acquire();
        threadB.start();
        A.release();
    }

    /**
     * Mid index returned. In an even array left mid index returned.
     * @return
     */
    public int findMidIndex(){
        return list.size()/2;
    }

    /**
     * List copied to List A and List B.
     * @param list
     * @param midIndex
     */
    public void split(List<Integer> list, int midIndex){
        List<Integer> list1 = list.subList(0, midIndex+1);
        List<Integer> list2 = list.subList(midIndex+1, 5);
        this.list1 = list1;
        this.list2 = list2;
        this.listA = new ArrayList<Integer>();
        this.listB = new ArrayList<Integer>();
        for(int i = 0; i<this.list1.size(); i++){
            this.listA.add(list1.get(i));
        }
        for(int i = 0; i<this.list2.size(); i++){
            this.listB.add(list2.get(i));
        }
    }

    /**
     * List A & B copied to main list. Called from merger thread.
     * @param listA
     * @param listB
     * @param list
     */
    public void mergeList(List<Integer> listA, List<Integer> listB, List<Integer> list){
        list.clear();
        int pointer = 0;
        for (Integer item: listA){
            list.add(pointer++, item);
        }

        for (Integer item: listB){
            list.add(pointer++, item);
        }
//        for(Iterator<Integer> i = listA.iterator(); i.hasNext();){
//            list.add(pointer, i.next())
//            list.add(, i.next());
    }
}
