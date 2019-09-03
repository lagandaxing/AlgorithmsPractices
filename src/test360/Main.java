package test360;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ololo on 2019/8/31.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n=getMaxTimesString(s);
        System.out.println(n);

    }
    public static int getMaxTimesString(String s){
        char[] chars=s.toCharArray();
        HashMap<Character ,Integer> map=new HashMap<>();
        for(char c:chars ){
            //System.out.println(c);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else {
                int i=map.get(c);
                map.remove(c);
                map.put(c,i+1);
            }

        }
        int max=0;
        Set<Character> set=map.keySet();
        for(Character c:set){
            int value= map.get(c);
           // System.out.println( "("+c+":"+value+"）,");
            if(value>max){
                max=value;
            }
        }

        return max;
    }
}
