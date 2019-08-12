package multithreading;

/**
 * @author duzj
 * @create 2019-08-11 16:19
 *
 * wait notify
 */
public class WaitDemo {
    public static void main(String[] args) {
       WaitDemo waitDemo = new WaitDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (waitDemo){
                    for (int i = 0; i <10 ; i++) {
                        System.out.println(Thread.currentThread().getName()+" i="+i);
                        if(i==5){
                            try {
                                System.out.println(Thread.currentThread().getName()+"让出cpu");
                                waitDemo.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }finally {
                                System.out.println(Thread.currentThread().getName()+"唤醒其它线程");
                                waitDemo.notifyAll();
                            }
                        }
                    }
                }
            }
        },"one").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (waitDemo){
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName()+" i="+i);
                        if(i==6){
                            try {
                                System.out.println(Thread.currentThread().getName()+"唤醒其它线程");
                                waitDemo.notifyAll();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }finally {
                                try {
                                    System.out.println(Thread.currentThread().getName()+"让出cpu");
                                    waitDemo.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        },"two").start();
    }
}
