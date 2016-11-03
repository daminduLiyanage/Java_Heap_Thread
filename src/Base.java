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

    public Base(List<Integer> list){
        this.list = list;
        split(list, findMidIndex());
        mainBase();
        //list.removeAll()
        System.out.println("list 1:" + list1 +" list 2 :"+list2);

        this.sort1 = new Heapsort(this.listA);
        this.threadA = new HeapThread(this.listA, this.sort1);
        this.sort2 = new Heapsort(this.listB);
        this.threadB = new HeapThread(this.listB, this.sort2);

        assist();
        try{
            this.threadA.join();
            this.threadB.join();
            this.mergeThread = new HeapMerger(this.listA, this.listB, this.list, this);
            this.mergeThread.join();
        } catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(list);
        //this.mergeThread = new HeapMerger(list, this.threadA, this.threadB);
    }

    public static void mainBase(){
        System.out.print("Static check ok");
    }

    static Semaphore A = new Semaphore(1);
    static Semaphore B = new Semaphore(0);

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

    public int firstArrayEndIndex(){
        return list.size()/2;
    }

    /**
     * Divides Array list to 2 parts
     * @param list
     */
    public int secondArrayStartIndex(List<Integer> list){
        return list.size()/2 + 1;
    }

    public int findMidIndex(){
        return list.size()/2;
    }

    public void split(List<Integer> list, int midIndex){
        //int partitionSize = IntMath.divide(list.size(), 2, RoundingMode.UP);
        List<Integer> list1 = list.subList(0, midIndex+1);//+1
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
