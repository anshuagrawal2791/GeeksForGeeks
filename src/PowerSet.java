import java.util.Scanner;

/**
 * Created by anshu on 12/01/17.
 */
public class PowerSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string:");
        String a = scan.next();

        printPowerSet(a);
    }

    private static void printPowerSet(String a) {

        for(int counter = 0 ; counter<Math.pow(2,a.length());counter++){
            for(int j=0;j<a.length();j++){
                if((counter & 1<<j)!=0)
                    System.out.print(a.charAt(j));
            }
            System.out.println("/");
        }
    }
}
