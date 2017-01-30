import java.util.Scanner;

/**
 * Created by anshu on 16/01/17.
 */
public class PartitionNumber {
    static int a[] = new int[200];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = scan.nextInt();
        partition(n,1,0);
    }

    private static void partition(int n,int smallest,int index) {
        if(n==0){
            for(int i=0;i<index;i++)
                System.out.print(a[i]+ " ");
            System.out.println();
        }
        for(int i=smallest;i<=n;i++){
//            if(i>n)continue;
            a[index]=i;
            partition(n-i,i,index+1);
        }
    }
}
