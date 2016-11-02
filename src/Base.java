/**
 * Created by Damindu on 11/2/2016.
 */
public class Base {
    HeapThread threadA;
    HeapThread threadB;
    HeapMerger mergeThread;
    int[] array;

    public Base(int[] array){

        this.threadA = new HeapThread(array);
        this.threadB = new HeapThread(array);
        this.mergeThread = new HeapMerger(array, )
    }

    public void assist(){
        this.threadA.start();
        this.threadB.start();
    }

    public

}
