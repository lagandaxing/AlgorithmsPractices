package jdexame;

/**
 * Created by ololo on 2019/8/24.
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();//男女人数
        int firends = sc.nextInt();//朋友关系数
        if(number<1||number>500){
            return ;
    }
    if(firends<1||firends>10000){
            return ;
    }
        int[][] relation= new int[number][2];//朋友关系数组
        int count=firends;
        Set<Integer> set=new HashSet<>();
        while( count>0){
            count--;
            int p1=sc.nextInt();
            int p2=sc.nextInt();
            if(p1<p2){
                set.add(p1);
            }else {
                set.add(p2);
            }
        }

        System.out.println(set.size());
            for (Integer i:set){
                System.out.println(i+" ");
            }
        sc.close();
        }


    }




