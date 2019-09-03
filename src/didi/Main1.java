package didi;

import java.util.Scanner;

/**
 * Created by ololo on 2019/8/27.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//员工数
        int m = in.nextInt();//项目数
        if(n<1||m>1000){
            return ;
        }
        int[] earnings=new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int x=in.nextInt();
                if(x>earnings[j]){
                    earnings[j]=x;
                }

            }

        }
        int result=0;
        for(int i = 0; i < m; i++){
            result+=earnings[i];
        }
        System.out.println(result);

    }
}
