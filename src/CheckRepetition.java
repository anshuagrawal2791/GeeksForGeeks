import java.util.Scanner;

/**
 * Created by anshu on 30/12/16.
 */
public class CheckRepetition {
    static char[] a;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int n = scan.nextInt();
            a = new char[n];
            String string = scan.next();
            a = string.toCharArray();
            int k = scan.nextInt();

            if(n%k!=0){
                System.out.println("0");
            }
            else if(n%k==1 || n%k==2) {
                System.out.println("1");

            }
            else{
                String a1 = string.substring(0,k);
                String b1 = string.substring(k,2*k);
//                System.out.println(a1);
//                System.out.println(b1);
                int n1=1,n2=1,l=2;
                for(int i=l*k;i<n;i=l*k){
                    String x = string.substring(i,i+k);
//                    System.out.println("i "+i);
//                    System.out.println(x);
                    if(x.matches(a1))
                        n1++;
                    else if(x.matches(b1))
                        n2++;
                    l++;
                }
                if((n1==1&&n2==(n/k)-1) ||(n2==1&&n1==(n/k)-1))
                    System.out.println("1");
                else
                    System.out.println("0");
            }

        }
    }
}
