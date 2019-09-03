package vipkid;

import java.util.*;

/**
 * Created by ololo on 2019/9/3.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine().trim();
        String[] inputArrayStr = str.split( ",");
        int size=inputArrayStr.length;
        long[] inputArray=new long[size];
        for(int i=0;i<size;i++){
           inputArray[i]= Long.parseLong(inputArrayStr[i]);
          // System.out.println(inputArray[i]);
            //System.out.println(inputArrayStr[i]);
        }
        Arrays.sort(inputArray);
        long[] min=new long[size];
        //int[] max=new int[size];
        int count=0;
       /* for(int i=0;i<size;i++){
            System.out.println(inputArray[i]);
        }*/
        int minsize=0;
        for(int i=0;i<size;i++){
            if(inputArray[i]<0){
                min[i]=inputArray[i];
                minsize++;
            }
        }

        //System.out.println(minsize);
        for(int i=0;i<minsize;i++){
            for(int j=minsize-1;j<size;j++){
                if(min[i]==-inputArray[j]){
                    count++;
                }
            }

        }
        System.out.println(count);


    }
}
