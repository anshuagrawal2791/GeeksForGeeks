/* package whatever; // don't place package name! */
import java.util.*;
import java.io.*;

class Prog
{
    public static void main(String[] args) throws java.lang.Exception
    {
        int a,b, count =0;
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] input1 = str1.split(" ");
        String[] input2 = str2.split(" ");
        StringBuilder output = new StringBuilder();
        for(int i=0; i< input2.length; i++){
            if(input2[i].charAt(0) == '%' && input2[i].charAt(1) == 's'){
                if(input2[i].length() > 5 &&  input2[i].charAt(2) == '[' && input2[i].charAt(5) == ':'){
                    a = input2[i].charAt(3);
                    b = input2[i].charAt(6);
                    output.append((input1[a].substring(0,b)) + " ") ;
                }else if(input2[i].length() >2 &&  input2[i].charAt(2)== '['){
                    a = input2[i].charAt(3);
                    output.append(input1[a]+ " ");
                }
                else {
                    output.append(input1[count] + " ");
                    count++;
                }
            }
            else
                output.append(input2[i]+" ");
        }
        output.toString();
        System.out.println(output);
    }
}