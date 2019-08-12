package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duzj
 * @create 2019-08-11 10:37
 * synchronized
 *
 * 如果出现异常会释放锁
 */
public class SynchronizedDemo {

    private int count = 0;
    private static int count2 = 0;


    private Object o = new Object();

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.run();
    }

    public void run() {
        //这里其实锁定是对象 其实就是有两个线程去o这个对象拿锁 谁拿到就谁用
        synchronized (o) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count=" + count);
        }
    }


    //synchronized作用在static 上面  其实就是要去问SynchronizedDemo拿锁 而不是到他的实例对象拿锁 等同于run3
    public synchronized static void run2() {
        count2++;
        System.out.println(Thread.currentThread().getName() + " count=" + count2);

    }

    //synchronized作用在static 上面  其实就是要去问SynchronizedDemo拿锁 而不是到他的实例对象拿锁
    public synchronized static void run3() {
        synchronized (SynchronizedDemo.class){
            count2++;
            System.out.println(Thread.currentThread().getName() + " count=" + count2);
        }
    }
}
