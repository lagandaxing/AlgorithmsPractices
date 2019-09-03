package test360;

import java.util.Scanner;

/**
 * Created by ololo on 2019/8/31.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        if(n>20000||m>20000){
            return;
        }
        int[] distances=new int[m];
        for(int i = 0; i < m; i++){
            distances[i]=in.nextInt();
        }
        int leftMax=n-1;
        int rightMax=0;
        int posible=0;
        int posiblel=0;
        int posibler=0;
        int posibleMax=n-distances[0];
        for(int i=0;i<m;i++){
            if(leftMax>distances[i]){
                //posiblel=leftMax-distances[i];
                leftMax=leftMax-distances[i];
                rightMax=rightMax+distances[i];
            }
            if(rightMax>=distances[i]){
                //posibler=rightMax-distances[i];
                rightMax=rightMax-distances[i];
                leftMax=leftMax+distances[i];
            }
            if((leftMax<distances[i])&&(rightMax<distances[i])){
                posibler=rightMax-distances[i];
                posiblel=leftMax-distances[i];
                posible=Math.min(posiblel,posibler);
            }

            if(posible<0){
                posibleMax=posibleMax-posible;
            }

        }

        System.out.println(posibleMax);


    }

}
