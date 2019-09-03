package jdexame;

/**
 * Created by ololo on 2019/8/24.
 *  输入
 多组（不超过 5 组）数据。

 每组输入数据分为三行，第一行有两个数字 n,m($0＜n,m\leq10000$)，
 分别表示集合 A 和集合 B 的元素个数。后两行分别表示集合 A 和集合 B。
 每个元素为不超出 int 范围的整数，每个元素之间有一个空格隔开。

 样例输入
 1 2
 1
 2 3
 1 2
 1
 1 2


 输出
 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开。
 样例输出
 1 2 3
 1 2
 */
import java.util.Arrays;
        import java.util.HashSet;
        import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            HashSet<Integer> hashset = new HashSet<Integer>();
            for(int i = 0; i < n; i++){
                hashset.add(in.nextInt());
            }
            for(int i = 0; i < m; i++){
                hashset.add(in.nextInt());
            }
            Object[] arr = hashset.toArray();
            int[] array = new int[arr.length];
            for(int i = 0; i < array.length; i++){
                array[i] = (int) arr[i];
            }
            Arrays.sort(array);
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i]+" ");
            }
        }


    }



}