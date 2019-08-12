package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duzj
 * @create 2019-08-11 15:41
 */
public class AtomicIntegerDemo {
    static  AtomicInteger ai = new AtomicInteger(0);

    public static void add(){
        System.out.println(Thread.currentThread().getName()+":"+ai);
        for (int i = 0; i <10 ; i++) {
            ai.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName()+":"+ai);
    }

    public static void main(String[] args) {
        List<Thread> lists = new ArrayList();

        for (int i = 0; i <10 ; i++) {
            Thread tmp = new Thread(()->add(),"thread"+i);
            lists.add(tmp);
        }


        lists.forEach((a)->a.start());
        lists.forEach(a-> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(ai.get());

    }
}
