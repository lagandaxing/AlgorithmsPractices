package ali;

/**
 * Created by ololo on 2019/8/30.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String[] splitWordsLikePyramid(String[] input) {

        int line=input.length;
        int[] lengths=new int[line];
        for(int i=0;i<line;i++){
            lengths[i]=input[i].length();

        }
        int sum=0;
        for(int i=0;i<line;i++){
            sum=sum+lengths[i];
        }


        String[] result=new String[line];
        result[0]=input[0];
        String nextLine=input[1];
        int j=0;
        int x=0;
        for(int i=0;i<line;i++){
            for(j=i;j<line;){
            if(result[x].length()>nextLine.length()){
                nextLine=nextLine+" "+input[++j];
            }else {
                continue;
            }
        }
        result[++x]=nextLine;
            i=j+1;
        }
        int maxlegth=result[x-1].length();
        //for()
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        /** 将用户输入以空格分隔,转成字符串数组,作为函数的入参 **/
        String[] inputArray = split(in.nextLine().trim(), " ");
        /*for (String line : inputArray) {
            System.out.println(line);
        }*/
        String[] output = splitWordsLikePyramid(inputArray);
        for (String line : output) {
            System.out.println(line);
        }
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (JDK1.4)
        // Direct code is quicker than StringTokenizer.
        // Also, StringTokenizer uses isSpace() not isWhitespace()

        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        List list = new ArrayList();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
        if (separatorChars == null) {
            // Null separator means use whitespace
            while (i < len) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // Optimise 1 character case
            char sep = separatorChars.charAt(0);
            while (i < len) {
                if (str.charAt(i) == sep) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else {
            // standard case
            while (i < len) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        }
        if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[])list.toArray(new String[list.size()]);
    }

    static String[] split(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, false);
    }
}