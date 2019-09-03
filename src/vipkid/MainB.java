package vipkid;

import java.util.Scanner;

/**
 * Created by ololo on 2019/9/3.
 */
public class MainB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        String[] inputArrayStr = str.split(",");
        int size = inputArrayStr.length;
        int[] inputArray = new int[size];
        for (int i = 0; i < size; i++) {
            inputArrayStr[i]=inputArrayStr[i].trim();
            inputArray[i] = Integer.parseInt(inputArrayStr[i]);
        }
        System.out.println(FindGreatestSumOfSubArray(inputArray));
    }

    public static  int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0], end = array[0];
        for(int num : array){
            end = Math.max(num, end + num);
            max = Math.max(max, end);
        }
        return max;
    }


}
