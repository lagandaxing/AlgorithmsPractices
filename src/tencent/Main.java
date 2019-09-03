package tencent;

import java.util.Scanner;

/**
 * Created by ololo on 2019/9/1.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int k=in.nextInt();
        if(t>100000||t<1||k>100000||k<1){
            return;
        }
        int[][] flowers=new int[t][2];
        for(int i = 0; i < t; i++){
            flowers[i][0]=in.nextInt();
            flowers[i][1]=in.nextInt();
        }

        for(int i = 0; i < t; i++){
            long times=getTime(flowers[i][0],flowers[i][1],k);
            System.out.println(times);
        }


    }
    public static  int  getTime(int right,int left,int k){
        int[] steptime=new int[left];
        int times=0;
        steptime[0]=1;
        for(int i=1;i<left;i++){
            for(int j=0;j<left;j++){
                if(i>pow(k,j)){
                    if(j==0){
                        steptime[i]=steptime[i]+1;
                    }else {
                        steptime[i]=steptime[i]+cxy( (i-pow(k,i)+1),1 );
                    }

                } else if(i==pow(k,j)){

                    steptime[i]=steptime[i]+1;
                }
                if(i<pow(k,j)){
                    continue;
                }
            }

        }
        for(int u=right-1;u<right;u++ ){
            times=times+steptime[u];
        }

        return times;
    }


    public static  long getTimes(int right,int left,int k) {
        int times=0;
        int[] steptime=new int[left];
        for(int i=right;i<left;i++){
            for(int j=0;j<right;j++){
                if(i>pow(k,j)){
                    if(j==0){
                        steptime[i]=steptime[i]+1;
                    }else {
                        steptime[i]=steptime[i]+cxy( (i-pow(k,i)+1),1 );
                    }

                } else if(i==pow(k,j)){

                    steptime[i]=steptime[i]+1;
                }else {
                    continue;
                }
            }
           // System.out.println( steptime[i]);


            times=times+steptime[i];
        }
        return times;
    }
    public static  int pow(int x,int y){
        if(y==0){
            return 0;
        }else {
            return (int) Math.pow(x,y);
        }
    }

  public static int cxy(int x,int y){
        if(x==0){
            return 1;
        }
        int result=(factorial(y)/(factorial(x)*factorial((y-x))));
        return result;
    }
    public static int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}

