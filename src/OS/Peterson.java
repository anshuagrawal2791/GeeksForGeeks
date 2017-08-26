package OS;


import java.util.Arrays;

/**
 * Created by anshu on 24/08/17.
 */
public class Peterson {

   static int ans=0;
    static boolean flag[];
    static int turn;
    public static void main(String[] args) {
        PetersonThread thread1 = new PetersonThread(0);
        PetersonThread thread2 = new PetersonThread(1);
        flag = new boolean[2];
        turn =0;
        thread1.start();
        thread2.start();


    }

    static class PetersonThread extends Thread{
        int max = 100000;
        int name ;

        public PetersonThread(int i) {
            name =i;
        }

        public void run(){
            flag[name]=true;
            turn = 1-name;
            while(turn==1-name&&flag[1-name])
                System.out.println(name+" is waiting");
            /////
            System.out.println("thread "+name+" has entered"+ Arrays.toString(flag)+"turn"+turn);
            try {
                Thread.sleep(100);
                for(int i=0;i<max;i++)
                    ans++;
                System.out.println(ans+" ans");
                System.out.println("thread "+name+" has left");
            } catch (Exception e) {
                e.printStackTrace();
            }


            ////
            flag[name]=false;
        }
    }

}
