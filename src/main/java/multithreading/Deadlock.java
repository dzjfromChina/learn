package multithreading;

/**
 * @author duzj
 * @create 2019-08-11 14:17
 *
 * 死锁的demo
 */
public class Deadlock {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Thread a = new Thread(()->demo2.A(),"A");
        Thread b = new Thread(()->demo2.B(),"B");
        a.start();
        b.start();
    }
}


class Demo2 {

    //final 是为了不让对象改变 导致锁改变失效
    private final Object A = new Object();
    private final Object B = new Object();

    public  void A(){
        synchronized(A){
            System.out.println("A开始");
            System.out.println(Thread.currentThread().getName()+":");
            B();
            System.out.println("A结束");
        }
    }

    public synchronized void B(){
        synchronized(B){
            System.out.println("B开始");
            System.out.println(Thread.currentThread().getName()+":");
            A();
            System.out.println("B结束");
        }
    }

}
