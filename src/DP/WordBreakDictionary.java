package DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anshu on 15/01/17.
 */
public class WordBreakDictionary {
    static ArrayList<String> dictionary = new ArrayList<>();
    static int cache[];

    public static void main(String[] args) {
        dictionary.add("mobile");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("man");
        dictionary.add("mango");
        dictionary.add("icecream");
        dictionary.add("and");
        dictionary.add("go");
        dictionary.add("i");
        dictionary.add("love");
        dictionary.add("ice");
        dictionary.add("cream");
        dictionary.add("samsung");

        wordBreak("iloveicecreamandmango","");
//        System.out.println();
        wordBreak("ilovesamsungmobile","");
        wordBreak("samsungandmangok","");
        System.out.println();


        String test = "iloveicecreamandmango";
        double t = System.nanoTime();
        wordBreak(test,"");
        System.out.println("time taken: "+(System.nanoTime()-t)+"");
        t = System.nanoTime();
        cache = new int[test.length()];
        Arrays.fill(cache,-1);
        wordBreak2(test,"",0,test.length());
        System.out.println("time taken: "+(System.nanoTime()-t));
//        System.out.println();
        wordBreak2("ilovesamsungmobile","",0,"ilovesamsungmobile".length());
        wordBreak2("samsungandmangok","",0,"samsungandmangok".length());
    }


    private static void wordBreak(String str,String result) {
        if(dictionary.contains(str))
            System.out.println(result.concat(str));

        for(int i=1;i<str.length();i++){
            String prefix = str.substring(0,i);

            if(dictionary.contains(prefix)){

                wordBreak(str.substring(i,str.length()),result.concat(prefix).concat(" "));
            }
        }



    }
    private static void wordBreak2(String str,String result,int i,int j) {
        System.out.println(i+" "+j);
        if(dictionary.contains(str.substring(i,j)))
            System.out.println(result.concat(str.substring(i,j)));

        for(int k=i+1;k<=j;k++){
            String prefix = str.substring(i,k);
            if(dictionary.contains(prefix)){
                wordBreak2(str,result.concat(prefix).concat(" "),k,j);
            }
//            String prefix = str.substring(0,i);
//
//            if(dictionary.contains(prefix)){
//
//                wordBreak2(str.substring(i,str.length()),result.concat(prefix).concat(" "));
//            }

        }



    }
}
