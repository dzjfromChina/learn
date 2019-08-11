package multithreading;

/**
 * @author duzj
 * @create 2019-08-11 13:43
 * <p>
 * <p>
 * 线程A调用了一个对象的一个同步方法  那么同时线程B能访问同一个对象的不同的同步方法吗?
 *
 * 不能!!  可以去掉synchronized 试下 会发现会交叉打印 但是有synchronized不会交叉打印
 */
public class SynchronizedDemo2 {


    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread demo1 = new Thread(() -> demo.p1(), "p1");
        Thread demo2 = new Thread(() -> demo.p2(), "p2");
        demo1.start();
        demo2.start();
    }


}

class Demo {
    public synchronized void p1() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public synchronized void p2() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
