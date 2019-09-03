package didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ololo on 2019/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//正n边型
        if(n<3||n>20000){
            return ;
        }
        int[] array = new int[n];
        boolean flag=true;
        int sum=0;
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
            sum+=array[i];
            if(flag&&array[i]<0){
                flag=false;
            }
        }
        if(n<5||n%2==1||flag){
            System.out.println(sum);
        }
        Arrays.sort(array);
       // int result=getMax(n,array);
        System.out.println(0);

    }

/*
    public static int  getMax(int n,int[]array){
        int result=0;
        for(int i=0;i<n;i++){
            result+=array[i];
        }

        return result;

    }
*/


}
