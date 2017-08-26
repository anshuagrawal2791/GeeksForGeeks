package OS;

import java.util.concurrent.Semaphore;

/**
 * Created by anshu on 26/08/17.
 */
public class SemaphoreClass {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Thread bees[] = new Thread[5];
        for(int i=0;i<5;i++)
            bees[i]=new Thread(new Worker(sem,i+1));
        for(int i=0;i<5;i++)
            bees[i].start();
    }
}
class Worker implements Runnable{
    Semaphore sem;
    int name;

    public Worker(Semaphore sem,int i) {
        this.sem = sem;
        name = i;
    }

    public void run(){
//        while(true){
            try {
                System.out.println(name+" wants to enter");
                sem.acquire();


                System.out.println(name+" is executing");
                Thread.sleep(2000);

                sem.release();
                System.out.println(name+" is done executing");




            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//        }

    }
}

