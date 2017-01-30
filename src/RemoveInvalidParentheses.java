import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by anshu on 12/01/17.
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string:");
        String a = scan.next();

        RemoveInvalid(a);

    }

    private static void RemoveInvalid(String a) {
        Queue<String> q = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        boolean level = false;
        int length = a.length();
        q.add(a);
        visited.add(a);
        while(!q.isEmpty()){
            String x = q.remove();
            if(isValid(x)){
                if(level==false){
                    length = x.length();
                    level = true;
                    System.out.println(x);
                }
                else{
                    if(x.length()==length)
                        System.out.println(x);
                    else
                        return;
                }
            }
            if(level==false){
                for(int i=0;i<x.length();i++){
                    if (!isParenthesis(x.charAt(i)))
                        continue;
                    String y = x.substring(0,i).concat(x.substring(i+1,x.length()));
                    if(!visited.contains(y)){
                        q.add(y);
                        visited.add(y);
                    }
                }
            }
        }
        return;


    }

    private static boolean isParenthesis(char c) {
        {
            return ((c == '(') || (c == ')'));
        }
    }


    private static boolean isValid(String a){
        int count =0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='(')
                count++;
            else if(a.charAt(i)==')')
                count--;
            if(count<0)
                return false;
        }
        if(count==0)
            return true;
        else
            return false;
    }
}
