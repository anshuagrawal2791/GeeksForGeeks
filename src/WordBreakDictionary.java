import java.util.ArrayList;

/**
 * Created by anshu on 15/01/17.
 */
public class WordBreakDictionary {
    static ArrayList<String> dictionary = new ArrayList<>();

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
        System.out.println();
        wordBreak("ilovesamsungmobile","");
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
}
