package jdexame;

/**
 * Created by ololo on 2019/8/24.
 * 样例输入
 4
 2 1 3 2
 样例输出
 2
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int size = sc.nextInt();
            if(size>100000){
                return;
            }
            int[] hight= new int[size];
            for(int i=0;i<size;i++){
                hight[i]=sc.nextInt();
            }
            int group=countGroup(hight,size);
            System.out.println(group);
        }
        sc.close();

    }
    public static  int countGroup(int[] hight,int size){
        int[] left=new int[size];
        int[] reight=new int[size];
        left[0]=reight[size-1]=1;
        for(int i=1;i<size;i++){
            left[i]=1;
            for(int j=0;j<i;j++){
                if(hight[i]>hight[j]){
                    left[i]=Math.max(left[i],left[j]+1);

                }
            }
        }
        for(int i=size-2;i>=0;i--){
            reight[i]=1;
            for(int j=size-1;j>i;j--){
                if(hight[i]>hight[j]){
                    left[i]=Math.max(reight[i],reight[j]+1);
                }
            }
        }
        int less=0;
        for(int i=0;i<size;i++){
            if(left[i]+reight[i]-1>less){
                less=left[i]+reight[i]-1;
            }
        }
        return size-less;
    }

}
