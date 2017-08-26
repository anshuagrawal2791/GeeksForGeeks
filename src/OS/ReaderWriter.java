package OS;

import javax.xml.crypto.Data;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by anshu on 26/08/17.
 */
public class ReaderWriter {
    public static final int NUM_OF_READERS = 3;
    public static final int NUM_OF_WRITERS = 2;
    public static void main(String[] args) {

        Database database = new Database();

        Thread[] readerArray = new Thread[NUM_OF_READERS];
        Thread[] writerArray = new Thread[NUM_OF_WRITERS];

        for (int i = 0; i < NUM_OF_READERS; i++) {
            readerArray[i] = new Thread(new Reader(i+1, database));
            readerArray[i].start();
        }

        for (int i = 0; i < NUM_OF_WRITERS; i++) {
            writerArray[i] = new Thread(new Writer(i+1, database));
            writerArray[i].start();
        }


    }
    static class SleepUtils {
        static void nap(){
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Database implements ReadWriteLock{
    Semaphore db,mutex;
    int readCount;

    public Database() {
        db = new Semaphore(1);
        mutex = new Semaphore(1);
        readCount=0;

    }

    @Override
    public void acquireWriteLock() {
        try {
            db.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void releaseWriteLock() {
        db.release();
    }

    @Override
    public void acquireReadLock() {
        try {
            mutex.acquire();
            readCount++;
            if(readCount==1)
                acquireWriteLock();
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void releaseReadLock() {
        try {
            mutex.acquire();
            readCount--;
            if(readCount==0)
                releaseWriteLock();
            mutex.release();



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Reader implements Runnable{
    int name;
    Database db;

    public Reader(int name, Database db) {
        this.name = name;
        this.db = db;
    }
    public void run(){
        while (true) {
            ReaderWriter.SleepUtils.nap();
            System.out.println(name + " wants to read");
            db.acquireReadLock();
            System.out.println(name + " is reading");
            ReaderWriter.SleepUtils.nap();
            db.releaseReadLock();
            System.out.println(name + " is done reading");
        }
    }
}
class Writer implements Runnable{
    int name;
    Database db;

    public Writer(int name, Database db) {
        this.name = name;
        this.db = db;
    }
    public void run(){
        while (true) {
            ReaderWriter.SleepUtils.nap();
            System.out.println(name + " wants to write....");
            db.acquireWriteLock();
            System.out.println(name + " is writing");
            ReaderWriter.SleepUtils.nap();
            db.releaseWriteLock();
            System.out.println(name + " is done writing!!!!!");
        }
    }
}




interface ReadWriteLock{
    void acquireWriteLock();
    void releaseWriteLock();
    void acquireReadLock();
    void releaseReadLock();

}
