package OS;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by anshu on 26/08/17.
 */
public class ProducerConsumer {
    public static void main(String[] args) {

        BoundedBuffer<Date> buffer = new BoundedBuffer<>();
        Thread producer = new Thread(new Producer(1,buffer));
        Thread consumer = new Thread(new Consumer(1,buffer));
        producer.start();
        consumer.start();

    }
}

class BoundedBuffer<E>{
    private static final int MAX_BUFFER_SIZE= 5;
    private E[] buffer;
    private int start,end;
    private Semaphore empty,full,mutex;

    public BoundedBuffer() {
        buffer = (E[])new Object[MAX_BUFFER_SIZE];
        start=0;
        end=0;
        empty = new Semaphore(MAX_BUFFER_SIZE);
        full=new Semaphore(0);
        mutex = new Semaphore(1);

    }
    public void insert(E item,int name) throws InterruptedException {
        empty.acquire();
        mutex.acquire();

        System.out.println(name+" is writing...");

        Thread.sleep(new Random().nextInt(3000));
        buffer[end]=item;
        end=(end+1)%MAX_BUFFER_SIZE;
        mutex.release();
        full.release();

    }
    public E remove(int name) throws InterruptedException {
        E consumed;
        full.acquire();
        mutex.acquire();
        System.out.println("consumer "+name+" is consuming...");
        Thread.sleep(new Random().nextInt(2000));
        consumed = buffer[start];
        start=(start+1)%MAX_BUFFER_SIZE;
        mutex.release();
        empty.release();
        return consumed;
    }

}
class Producer implements Runnable {
    int name;
    BoundedBuffer<Date> buffer;

    public Producer(int name, BoundedBuffer<Date> buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    public void run(){
        Date item;
        while (true){
            item=new Date();
            try {
                Thread.sleep(new Random().nextInt(3000));

                buffer.insert(item,name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{
    int name;
    BoundedBuffer<Date> buffer;

    public Consumer(int name, BoundedBuffer<Date> buffer) {
        this.name = name;
        this.buffer = buffer;
    }
    public void run(){
        while(true){
            try {
                Thread.sleep(new Random().nextInt(3000));

                System.out.println("output of "+name+" is "+buffer.remove(name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

