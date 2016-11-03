import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damindu on 11/2/2016.
 */
public class Test {
    public static void main(String[] args){
        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(10);
        list.add(3);
        System.out.println("Unsorted List: "+list);
        System.out.println("*\n*\n*");
        Base base = new Base(list);
        System.out.println("\nPress enter to exit");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }



}
