import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anshu on 29/12/16.
 */
public class RotateAndDelete {
    static ArrayList<Integer> a;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int n = scan.nextInt();
            a = new ArrayList<>();
            for(int i=0;i<n;i++)
                a.add(scan.nextInt());
            int s = 0;
            while(a.size()>1){
                rotate(a);
                remove(a,s);

                s++;
            }
            System.out.println(a.get(0));

        }
    }

    private static void remove(ArrayList<Integer> a, int s) {
        int k=0;
        if(a.size()-1-s>=0)
            k = a.size()-1-s;
        a.remove(k);

    }

    private static void rotate(ArrayList<Integer> a) {
        int x = a.get(a.size()-1);
        a.remove(a.size()-1);
        a.add(0,x);
    }
}
