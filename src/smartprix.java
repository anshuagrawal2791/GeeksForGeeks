import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by anshu on 16/01/17.
 */
public class smartprix {
    static String output = "";
    static int count =-1;
    static String str1;
    static String[] input1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str1 = sc.nextLine();
        String str2 = sc.nextLine();
        input1 = str1.split(" ");
        char [] input2 = str2.toCharArray();

        for(int i=0;i<input2.length;i++){
            if(input2[i]=='%'){
                i = parse(input2,i+1,i);
            }
            else{
                output = output.concat(String.valueOf(input2[i]));
            }
        }
        System.out.println(output);

    }

    private static int parse(char[] input2, int i,int initial) {
        if(input2[i]!='s'){
            output=output.concat(String.valueOf(input2[i-1]+input2[i]));
            return i;
        }
        else{
            return parse2(input2,i+1,initial);
        }

    }

    private static int parse2(char[] input2, int i,int initial) {
        if(input2[i]=='['){
            i+=1;
            String x ="";
            int k;
            for(k=i;input2[k]!=']';k++){
                x= x.concat(String.valueOf(input2[k]));
            }
            int y=-1;
            try{
                y = Integer.parseInt(x);
            }catch (Exception e){
                return parse3(input2,k+1,y,initial);

            }

            return parse3(input2,k+1,y,initial);

        }
        else{
            count++;
           return parse3(input2,i,count,initial);
        }
    }

    private static int parse3(char[] input2, int i, int y,int initial) {
        if(input2[i]==':'){
            i+=1;
            String x="";
            int k;
            for(k=i;Character.isDigit(input2[k]);k++){
                x=x.concat(String.valueOf(input2[k]));
            }
            int z = Integer.parseInt(x);
            try{
                if(input1[y].length()>z)
                    output = output.concat(input1[y].substring(0,z));
                else
                    output = output.concat(input1[y]);

            }catch (Exception e){
                int l;
                String p = "";
                for(l = initial;l<k;l++)
                    p=p.concat(String.valueOf(input2[l]));
//                output = output.concat(p);
                output = output.concat(p);
                return k-1;
            }
            return k-1;
        }
        else{
            try {
                output= output.concat(input1[y]);
            }catch (Exception e){
                int l;
                String p = "";
                for(l = initial;l<i;l++)
                    p = p.concat(String.valueOf(input2[l]));
                output = output.concat(p);
                return i-1;
            }


            return i-1;
        }
    }
}
